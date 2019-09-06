# Encode and Decode Strings

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

```bash
string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
```

Machine 2 (receiver) has the function:

```bash
vector<string> decode(string s) {
  //... your code
  return strs;
}
```

So Machine 1 does:

```bash
string encoded_string = encode(strs);
```

and Machine 2 does:

```bash
vector<string> strs2 = decode(encoded_string);
```

strs2 in Machine 2 should be the same as strs in Machine 1.

