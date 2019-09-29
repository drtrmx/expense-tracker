# Expense Tracker Description
The following app is intended to serve as a simple expense tracker to help organize and manage every day financial decisions by being able to see the details where your money is disappearing each month. The more details you input, the more detailed picture you get...

## Functional Requirements
- adding new by pressing the plus/add button
- modifying by clicking the edit button or the object itself
- deleting by clicking the delete button
- sorting by date, type, contributors, value, details, settlement status
- drawing graphs about expenses
- adding contributors/sharing expenses
- data is stored in databases and can be accessed through the user interface after successful authentication

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

## Technical Glossary

**TBA**

## User Roles
- admin:
    can view, edit, delete all expense objects and users
- owner: 
    can view, edit, delete all the expense object created by the given user
- contributor:
    can view, edit all the expense object which given user was added to
