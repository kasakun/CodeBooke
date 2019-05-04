# !/usr/bin/Python3
"""
The script will search all problems in the same directory and then show some
simple stats. Each entry in the stats table is linked to the real problem dir.
"""
import os
import re
from typing import Tuple, List, Dict

_EASY = r'\(Easy\)'
_MEDIUM = r'\(Medium\)'
_HARD = r'\(Hard\)'


def get_problems() -> Dict[int, str]:
    """Return the ordered list of dirs"""
    dirs = os.listdir()
    dict = {}

    for dir in dirs:
        splited_dir = dir.split('-')
        if splited_dir[0].isdecimal(): 
            dict[int(splited_dir[0])] = dir

    sorted_dict = {key: dict[key] for key in sorted(dict)}

    return sorted_dict


def make_up_titles() -> str:
    """Create a standard head for README"""
    white_line = ''
    head = '# LeetCode\n\n'
    sub_title = '## Problems\n\n'

    lines = ''.join((head, white_line, sub_title))

    return lines


def make_up_form(problems: dict) -> Tuple[str, int, int, int]:
    """
    TODO: Add tags to each problem.
    Construct a table to store all problems solved.
    """
    easy_counter = 0
    medium_counter = 0
    hard_counter = 0

    form_head = '|#|Problems|Level|\n'
    form_line = '|---|----------|---|\n'
    
    lines = ''.join((form_head, form_line))

    for index, problem_dir in problems.items():
        if re.search(_EASY, problem_dir):
            easy_counter += 1
            level = 'Easy'
            problem = problem_dir.replace('(Easy)', '')
        elif re.search(_MEDIUM, problem_dir):
            medium_counter += 1
            level = 'Medium'
            problem = problem_dir.replace('(Medium)', '')
        else:
            hard_counter += 1
            level = 'Hard'
            problem = problem_dir.replace('(Hard)', '')

        problem = problem.split('-')
        problem = ' '.join(problem[1:])
        line = ''.join(('|', str(index), '|[', 
                        problem, '](./', problem_dir, ')|', 
                        level, '|', '\n'))
        
        lines = ''.join((lines, line))
    
    return (lines, easy_counter, medium_counter, hard_counter)


def write_to_markdown(problems: dict):
    """Output readme a markdown file."""
    with open('README.md', 'w+') as file:
        file.write(make_up_titles())
        lines, easy_counter, medium_counter, hard_counter = make_up_form(problems)
        total = easy_counter + medium_counter + hard_counter
        stat_line = ''.join((':guardsman:', '**Solved** :', str(total), ' ',
                             ':lollipop:', '**Easy**: ', str(easy_counter), ' ',
                             ':chocolate_bar:', '**Medium**: ', str(medium_counter), ' ',
                             ':birthday:', '**Hard**: ', str(hard_counter), '\n\n'))
        file.write(stat_line)
        file.write(lines)


if __name__ == "__main__":
    """Main Func"""
    problems = get_problems()
    write_to_markdown(problems)