## Setup

### Pre-requisite

- Gradle using - 6.8.3
- npm version - 6.14.11
- java version - 11.0.10 (This must be JDK not JRE)
  JAVA_HOME is set to above java version All bin/executable directories of above to the class path

Port 3000 and 5000 are used for the client and server, so they must be available.

*NOTE* - GIT bash command line was used
to run following commands (inside the cloned directory)

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

**Open another git bash terminal**

### Install

```
gradle npm_install
(This might take a while)
```

### Run

```
gradle run_client
It will open a page in http://localhost:3000/

```
PS: This is react-typescript app which is templated using
(i.e. npx create-react-app my-app --template redux-typescript)

### Run Test

Currently, it is having issue with running through gradle to run test Import the project in IntelliJ, need to run test
from there.

```
TODO fix test library
gradle test
```
