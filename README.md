## Setup

### Pre-requisite

- Gradle using - 6.8.3
- npm version - 6.14.11
- java version - 11.0.10 (This must be JDK not JRE)
  All bin/executable directories of above to the class path

Port 3000 and 5000 are used for client and server, so they must be available

### Setup

```
git clone git@github.com:jitgit/react-kotlin.git
cd react-kotlin
```

## Server

#### Run

This will run the server in the background on port 5000
http://localhost:5000

```
gradle run
```

## Client

PS: This is react-typescript app which is templated using
`npx create-react-app my-app --template redux-typescript`

## Install

```
gradle npm_install
This might take a while does npm install and then start the react app
```

gradle npm_install

```

### Run
```

gradle run_client It will open a page in http://localhost:3000/

```

### Run Test
```

gradle test

```
