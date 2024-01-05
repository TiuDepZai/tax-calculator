# Tax Calculator

A novel and naive tax calculator.
## Table of Contents

- [About](#about)
- [Getting Started](#getting-started)
- [Usage](#usage)

## About

#### Purpose
To start an independent coding project.

#### Key Features
Broken down into 3 parts
- API Requests
- Service
- Data Access / Communication
  

## Getting Started

### Installation

```bash
# Clone the repository
git clone https://github.com/your-username/your-repository.git

# Change into the project directory
cd your-repository

```

```docker
# Clone repository from docker
docker pull tiudepzai/tax-calculator

# Run the docker
docker run tiudepzai/tax-calculator
```

### Prerequisites

Java 17

Maven


## Author Notes

#### Assumptions made

- The user will send a ```get``` request with the relevant information attached as part of the body. This way they don't have to put it into the url and potentially expose it.
- Users will put in the correct input. No try catch has been implemented due to time limitations.
- 

#### Personal notes
I made this in a rush please forgive the shortcomings. 
I haven't made a lot of test cases, I don't promise I will.
