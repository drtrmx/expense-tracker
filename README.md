# Expense Tracker Description
The following app is intended to serve as a simple expense tracker to help organize and manage every day financial decisions by being able to see the details where your money is disappearing each month. The more details you input, the more detailed picture you get...

## Functional Requirements
- adding new by pressing the plus/add button
- modifying by clicking the edit button or the object itself
- deleting by clicking the delete button
- sorting by date, category, contributors, value, description
- drawing graphs about expenses
- adding contributors/sharing expenses
- data is stored in databases and can be accessed through the user interface after successful authentication

### Databases
![alt text](database.png "Database diagram")
#### Users
- Id (number, autoincrement)
- Username (varchar)
- Role (number) --> 0: admin, 1: owner, 2: contributor
#### Transactions
- Id (number, autoincrement)
- UserId (number)
- Title (varchar)
- Value (float)
- CategoryId (number)
- PlaceId (number)
- Date (date)
- Description (varchar)
- ContributorId (number)
#### Categories
- Id (number, autoincrement)
- Name (varchar)
#### Places
- Id (number, autoincrement)
- Name (varchar)

### API endpoints
#### Users

**POST** `/users/login`

Request (Content-type: text):

    username

Response: 

    {
    	id: number;
        username: string;
        role: number;
    }

**POST** `/users/register`

Request:

    {
        username: string;
        password: string;
    }
    
**GET** `/users`

Request:

    {
    }

Response:

    [
    	{
    		id: number;
    		username: string;
    		role: number;
    	},
    	.
    	.
    	.
    ]

**POST** `/users`

Request:

    {
    	username: string;
    	role: number;
    }

Response: 

    {
    	id: number;
    }
#### Transactions
##### Sequence diagram
![alt text](sequence.png "Sequence diagram")

**GET** `/transactions`

Request:

    {
    }

Response:

    [
    	{
    		id: number;
    		title: string;
    		value: number;
    		category: {
    		    id: number;
    		    name: string;
    		}
    		place: {
    		    id: number;
    		    name: string;
    		}
    		date: string;
    		description: string;
    		contributorId: number;
    	},
    	.
    	.
    	.
    ]
    
**GET** `/transactions/{id}`

Request:

    {
    }

Response:

    {
    	id: number;
    	title: string;
    	value: number;
    	category: string;
    	date: string;
    	description: string;
    	contributorId: number;
    }

**POST** `/transactions`

Request:

    {
        title: string;
        value: number;
        category: string;
        date: string;
        description: string;
        contributorId: number;
    }

Response: 

    {
    	id: number;
    }

**PUT** `/transactions/{id}`

Request:

    {
        title: string;
        value: number;
        category: string;
        date: string;
        description: string;
        contributorId: number;
    }

Response: 

    {
    }

**DELETE** `/transactions/{id}`

Request:

    {
    }

Response: 

    {
    }
#### Categories
**GET** `/categories`

Request:

    {
    }

Response:

    [
    	{
    		id: number;
    		name: string;
    		places: [
    		    {
    		        id: number;
    		        name: string;
    		    },
    		    .
    		    .
    		    .
    		]
    	},
    	.
    	.
    	.
    ]
    
**GET** `/categories/{id}`

Request:

    {
    }

Response:

    {
    	id: number;
    	name: string;
        places: [
            {
                id: number;
                name: string;
            },
            .
            .
            .
        ]
    }

**POST** `/categories`

Request:

    {
        name: string;
        places: [
            {
                id: number;
            },
            .
            .
            .
        ]
    }

Response: 

    {
    	id: number;
    }

**PUT** `/categories/{id}`

Request:

    {
            name: string;
            places: [
                {
                    id: number;
                },
                .
                .
                .
            ]
        }

Response: 

    {
    }

**DELETE** `/categories/{id}`

Request:

    {
    }

Response: 

    {
    }
#### Places
**GET** `/places`

Request:

    {
    }

Response:

    [
    	{
    		id: number;
    		name: string;
    	},
    	.
    	.
    	.
    ]
    
**GET** `/places/{id}`

Request:

    {
    }

Response:

    {
    	id: number;
    	name: string;
    }

**POST** `/places`

Request:

    {
        name: string;
    }

Response: 

    {
    	id: number;
    }

**PUT** `/places/{id}`

Request:

    {
            name: string;
        }

Response: 

    {
    }

**DELETE** `/places/{id}`

Request:

    {
    }

Response: 

    {
    }

## Non-Functional Requirements

### Availability
- some of the functions are only available after successful authentication
- data being added/modified in user objects is being authenticated/validity checked

### Security
- password storage, user authentication, etc implemented based on ISO/IEC 27002 guidelines
- ~~a bunch of legal buzzwords and stuff about taking zero responsibility, being not liable for anything~~
- our user's security is our top priority

### Efficiency
- data is being accessed and modified in real time

### Development
#### Tools
- IntelliJ IDEA Ultimate 2019.2
- Java 8
- Gradle 5.6.2
- Spring Boot Framework 2.1.8
- H2 Database
#### Setup
The project was generated by Spring Initializr (https://start.spring.io/). No additional setup was necessary.
#### Project structure
The root package of the project is `hu.elte.alkfejl.expensetracker`.
Inside this package are 4 more packages and the base application class that starts the application.
- `security` contains everything that is needed for user authentication
- `controllers` contains the controller classes for the 4 end-points
- `entities` contains the entity classes for the database
- `repositories` contains the database repositories

## Technical Glossary

**TBA**

## User Roles
- admin:
    can view, edit, delete all expense objects and users
- owner: 
    can view, edit, delete all the expense object created by the given user
- contributor:
    can view, edit all the expense object which given user was added to
