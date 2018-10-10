# DizasterX-WebApp

Front End of DizasterX

## Front End Repo

React + Redux + Ant-design

`WebApp` is the directory for local development and local test.

### Structure

```bash
WebApp/
├── public/
│   ├── favicon.ico
│   ├── index.html
│   ├──manifest.json
│
├── src/
|   │
│   ├── actions/
|   │   ├── fetchData.js
|   │   ├── updateForm.js
|   │   └── urlConcat.js
|   │
│   ├── Components/
|   │   ├── WrappedForm.js
|   │   └── WrappedList.js
|   │
│   ├── reducers/
|   │   ├── fetchData.js
|   │   ├── formValues.js
|   │   ├── index.js
|   │   └── url.js
|   │
|   ├── App.js
|   ├── App.css
|   ├── index.js
|   ├── index.css
|   ├── logo.svg
|   ├── registerServiceWorker.js
|   └── store.js
|
├── package-lock.json
├── package.json
└── README.md
```

### Function Description

#### `src/`

`App.js` : describes the layout of homepage

`index.js` : includes Redux setup

`store.js` : Redux setup

#### `components/`

`WrappedForm.js` : component of search bars. It is a form with 4 form items(date picker, state picker, disaster picker and submit buttom).

`WrappedList.js` : component which displays the searching result. 

#### `actions/`

`updateForm.js` : action which updates the latest values of form into the Redux `store`.

`urlConcat.js` : action which concatentates URLs and updates the latest URL into the Redux `store`.

`fetchData.js` : action which fetches data from webapi and updates the latest data into the Redux `store`.

#### `reducers/`

`index.js` : root reducer which combines other reducers

`formValues.js` : reducer corresponding to `updateForm.js` action.

`url.js` : reducer corresponding to `urlConcat.js` action.

`fetchData.js` : reducer corresponding to `fetchData.js` action.

#### Notes

`cart.js` and `shelf.js` are test files and irrelevant to the `WebApp` project.