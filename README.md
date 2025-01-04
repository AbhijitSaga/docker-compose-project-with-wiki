API Documentation
1. Welcome Message API (GET)
Endpoint: http://localhost:8081/welocom/{name}
Method: GET
Description: Returns a welcome message with the given name.

URL Parameter:

name (Path Parameter): The name to include in the welcome message.
Response:
Copy code
{
  "message": "Hii, {name}!"
}


2. Text Message Save API (POST)
Endpoint: localhost:8081/textmsg?name=rishav
Method: POST
Description: Saves the provided text message in a .txt file within the Docker container and prints all saved messages.

Request Body:
{
  "message": "Your text message here"
}
Response:
{
  "status": "success",
  "message": "Message saved successfully."
}




3. Student Data Save API (POST)
Endpoint: http://localhost:8081/student
Method: POST
Description: Saves a student's name and city into  database.

Request Body:

json
Copy code
{
  "name": "abhijit5",
  "city": "noida"
}

Response:
{
  "name": "abhijit5",
  "city": "noida"
}




4. Get All Students API (GET)
Endpoint: http://localhost:8081/student
Method: GET
Description: Retrieves all student data stored in the Docker container database.

Response:
{
 
    {
      "name": "abhijit5",
      "city": "noida"
    },
    {
      "name": "rishav",
      "city": "delhi"
    }
  
}

