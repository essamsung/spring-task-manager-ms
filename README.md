# Task Manager Microservice

## Overview

A lightweight Spring Boot microservice for managing tasks.

## Tech stack
- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- H2 in-memory database

## API specs

Base path: `/tasks`

### Create a new Task

- POST `/create`
- Request body:
```json
{
"title": "Intro to OpenGL",
"author": "Mario Mark",
"description": "Use OpenGL for Android",
"project": "Graphics Project"
}
```
- Success response: `201 Created`
- Errors: `400 Bad Request` for validation failures; `412 Preconidion Failed` if a task with the same title + author already exists.

### Fetch a single Task by id

- GET `/fetch`
- Query parameter: `id (string, required) `
- Success response: `200 OK` with TaskDto JSON 

```json
{
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "title": "Implement User Authentication",
    "author": "Alice Johnson",
    "description": "Create a secure user authentication system using JWT.",
    "status": "pending",
    "project": "EMEA project",
    "createdAt": "2025-09-29T13:23:16",
    "updatedAt": "2025-09-29T13:23:16"
}
```

- Errors: `404 Not Found` if the task does not exist.

### Return all tasks
- GET `/list` 
- Success response: `200 OK` with JSON array of TaskDto.

### Update an existing Task
- PUT `/update/{id}`
- Path parameter: `id (string, required)` 
- Request body: UpdateTaskDto (JSON) 
```json
{
"title": "Intro to OpenGL",
"author": "Mario Mark",
"description": "Use OpenGL for Android",
"project": "Graphics Project"
}
```
- Success response: `200 OK`
- Errors: `400 Bad Request` for validation; `404 Not Found` if no task with given id

## Running the Tasks Microservice 

### Using GitHub registry:
The MS is available in [GitHub GHCR](https://github.com/users/essamsung/packages/container/package/tasks-ms) as public image.
Navigate to the docker-compose directory and run:
```shell
docker compose up -d
```
The service will be available at `localhost:9000`.
The repo contains a postman collection that you can use to test out the basic operations provided by the API:
./TasksAPI.postman_collection.json

### Using IntelliJ:

The repo could be checked out and run the TaskManagerApplication configuration directly.
From there you can use the included collection directly.
