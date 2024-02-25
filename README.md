**Elevate communication and productivity with Gmail Server—an innovative hub for seamless email experiences**

---

**A fully designed usable web application using Spring and VUE JS**

## Github link:

https://github.com/mahfouz72/mail-service

## Contributors

1.Aly El-Din Mohamed El Sayed **21010835**

2.Mohamed Mahfouz Mohamed **21011210**

3.Esmail Mahmoud Hassan ******21010272**

4.Youssif Khaled Ahmed **21011655**

# Running process

---

The attached Pom.xml, Main.Js, vue.config.js, and index.html files serve the purpose of instantiating the required libraries for our project.
After Setting up the project using the Uploaded Source Code:

You should Use the Commands “npm install primevue”.

- It is advised to Modify the Pom.xml file to match the versions used on your machine.

**Running front end**

 using npm run serve command and make sure that it didn’t open in the same port with spring boot you can modify the running portin thee  config file

**Running back end**

open backend folders in any ide and run using the normal run button or with maven 

# UML design

---

**Service package**

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/c3f31751-46e3-49ea-ac40-fb674867767b/Untitled.svg)

---

**Controller package**

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/5cd1e70c-4993-47eb-ace3-487814db719d/Untitled.svg)

---

**Model package**

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/d7299661-5138-40a3-b409-2893fcffa9e8/Untitled.svg)

---

**Full UML**

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/3695df07-df57-4b08-9e6b-273004ee93a1/Untitled.svg)

# Design patterns

---

## Facade

---

### Usage

The Façade pattern simplifies access to a related set of objects by providing one object that all objects outside the set use to communicate with the set.

### How It’s used Mail-service?

The facade encapsulates the logic of **sending emails**, **handling drafts**, **and managing attachments**. This encapsulation promotes a clean separation of concerns, as the complexity of these operations is hidden behind a simplified interface provided by the facade.

### Consequences of using Facade pattern

1.**Simplified Interface:**

- The **`MailSenderFacade`** provides a simplified method **`sendMail`** that abstracts away the complexity of dealing with various services (UserService, DraftService, AttachmentService) and their interactions.

2.**Encapsulation:**

- The facade encapsulates the interactions with **`DraftService`**, **`AttachmentService`**, and **`UserService`**. Clients only need to interact with the **`MailSenderFacade`**, which hides the details of these services.

3.**Reduced Dependency:**

- Clients depend only on the **`MailSenderFacade`**, not on the individual services. This reduces the coupling between clients and the underlying subsystem components, making it easier to modify or extend the system without affecting clients.

4.**Centralized Code:**

- The code related to sending mail, managing drafts, handling attachments, and interacting with users is centralized within the facade. This makes the codebase more organized and easier to maintain.

5.**Promotes Good Design Practices:**

- Encapsulation and abstraction promoted by the facade pattern adhere to good design practices, such as the separation of concerns and the single responsibility principle.

## Filter

---

### Usage

Filter pattern is a design pattern that enables developers to filter a set of objects using different criteria and chaining them in a decoupled way through logical operations.

### How It’s used Mail-service?

Used to filter mails according to some ciriteria.

```java
public interface Filter {
    List<Mail> filter(List<Mail> mails);
}
```

### Consequences of using Filter pattern?

1.**Modularity and Extensibility:**

- The Filter Design Pattern provides a modular way to encapsulate individual filtering criteria (e.g., sender, receiver).
- New filtering criteria can be added easily by implementing the **`Filter`** interface without modifying existing filters or the code that applies filters.

2.**Avoiding Code Duplication:**

- By using a common interface (**`Filter`**), the filtering logic is encapsulated and can be reused across different types of filters.
- This avoids code duplication and promotes a cleaner, more maintainable codebase.

3.**Separation of Concerns:**

- Each filter has a single responsibility: applying a specific filtering criterion.
- Separating filtering concerns into distinct classes adheres to the single responsibility principle and makes the codebase more maintainable.

## Singleton

---

### Usage

the Singleton design pattern is a creational design pattern that ensures a class has only one instance and provides a global point to this instance. This pattern is useful when exactly one object is needed to coordinate actions across the system.

### How It’s used in Mail-service application?

The **`UserService`** class in the provided code is designed as a Singleton, following the Singleton pattern. The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. In the context of your code, the **`UserService`** has a single instance (**`instance`**) that is shared across the entire application.

```java
public static synchronized UserService getInstance() {
    if(instance == null)
        instance = new UserService();
    return instance;
}
```

### Consequences of using Singleton pattern?

1. **Resource Efficiency:**
- Creating a single instance and reusing it can be resource-efficient, especially if the class involves heavy initialization or resource-intensive operations.

2.**Global Access:**

- The Singleton pattern provides a global point of access to the instance. This can be advantageous when a single instance needs to be shared and accessed throughout the application.

## Chain of responsibility

---

### Usage

Chain of responsibility pattern is used to achieve loose coupling in software design where a request from the client is passed to a chain of objects to process them. Later, the object in the chain will decide themselves who will be processing the request and whether the request is required to be sent to the next object in the chain or not.

### How It’s used in Mail-service application?

There should be a base Handler class that declares the common interface for all concrete handlers. It might include methods like handle and setNext (to set the next handler in the chain).
Concrete Handler Classes (ValidPasswordHandler and UserExistsHandler):

### Consequences of using Chain of responsibility pattern?

create a flexible and modular way to process authentication-related requests

## Strategy

---

### Usage

It's worth noting that the Strategy pattern is more general and can involve multiple methods, whereas **`Comparable`** is specifically focused on providing a single method for comparison.

### How It’s used in Mail-service application?

The **`Comparable`** interface allows a class to define a single method (**`compareTo`**) that determines how instances of that class should be compared to each other, and this is somewhat akin to the Strategy pattern.

In the case of **`Comparable`**, the strategy is the specific comparison logic implemented in the **`compareTo`** method. Other classes or components that need to compare instances of the class can do so using this standardized strategy.

## Builder

---

### Usage

The Builder design pattern is a creational pattern that is used to construct a complex object step by step. It allows you to create different representations of an object by separating the construction process from the actual representation. This pattern is particularly useful when an object has a large number of optional parameters or configuration settings.

- The **`Mail`** object is a complex object with multiple attributes (e.g., id, from, to, subject, attachments, body, dateTime, priority).
- Constructing this object directly using a constructor with numerous parameters can lead to code that is difficult to read and maintain, especially when dealing with optional parameters.

### How It’s used in Mail-service application?

- When updating a draft, not all attributes of the original **`Mail`** object need to be modified. Some attributes may remain the same, while others need to be updated.
- The Builder pattern allows for selective modification of specific attributes by providing a fluent interface to set only the necessary attributes.

```java
Mail updatedDraft = new MailBuilder()
                    .setId(id)
                    .setFrom(newDraft.getFrom())
                    .setTo(newDraft.getTo())
                    .setSubject(newDraft.getSubject())
                    .setAttachments(draft.getAttachments())
                    .setBody(newDraft.getBody())
                    .setDateTime(LocalDateTime.now().withNano(0))
                    .setPriority(newDraft.getPriority())
                    .build();
```

# Design decisions

---

- **Contacts**: They are designed to be users that the user could save them in contacts list, and
    
    each contact must have name it’s available that the contact have multi email addresses in condition that the email address is owned by a registered user in creating or reset operations 
    
    **Attributes**: Name, List of email addresses
    
    **Methods:** Create, rename, reset email, delete
    
- Drafts: They are designed to be a List of emails that each user owns
- Each user will be saved in a separate file using JSON files
- you can’t move mail to not existing folder
- moving mails will not remove it from its current folder
- sorting and filtering will be done in the current folder only

---

**JSON SChema**

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/ae25ad77-a921-4dd3-91aa-2e6f58f710ff/Untitled.jpeg)

# Snap shots

---

![WhatsApp Image 2023-12-28 at 1.17.17 AM.jpeg](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/97bac201-2e58-4d28-bce6-edab339d98f9/WhatsApp_Image_2023-12-28_at_1.17.17_AM.jpeg)

![WhatsApp Image 2023-12-28 at 1.29.25 AM.jpeg](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/8e9b5164-148d-4b3c-a088-20b533e14b9b/WhatsApp_Image_2023-12-28_at_1.29.25_AM.jpeg)

![WhatsApp Image 2023-12-28 at 1.31.42 AM.jpeg](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/17f3f01a-dc58-4b51-9b83-09f6069b3c37/WhatsApp_Image_2023-12-28_at_1.31.42_AM.jpeg)

![WhatsApp Image 2023-12-28 at 1.31.28 AM.jpeg](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/8d95a5f8-5bab-4a67-bc4d-6aed8a74159e/WhatsApp_Image_2023-12-28_at_1.31.28_AM.jpeg)

![WhatsApp Image 2023-12-28 at 1.03.52 AM.jpeg](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/7a485067-5ab7-4b6e-ae56-840317ed6dd8/WhatsApp_Image_2023-12-28_at_1.03.52_AM.jpeg)

![WhatsApp Image 2023-12-28 at 1.07.53 AM.jpeg](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/118c8666-926a-4dbb-9260-1a548a6130c5/WhatsApp_Image_2023-12-28_at_1.07.53_AM.jpeg)

![WhatsApp Image 2023-12-28 at 1.09.21 AM.jpeg](https://prod-files-secure.s3.us-west-2.amazonaws.com/1d8335ab-63af-492c-be05-7e4ce08a9bdb/6db2a7fd-f2d0-4b96-b449-be49bf649921/WhatsApp_Image_2023-12-28_at_1.09.21_AM.jpeg)

# **Mail Server Application User Guide**

## **Introduction**

Welcome to the Mail Server Application! This guide will walk you through the functionalities and usage of the different components provided in the application.

### **Table of Contents**

1. Attachments
2. Contacts
3. Folders
4. Mails
5. Users

## **Attachments**

---

### **1. Get All Attachments**

- **Endpoint:** **`GET /attachments`**
- **Description:** Retrieve a collection of all attachments.

### **2. Attach File**

- **Endpoint:** **`POST /attach`**
- **Description:** Upload an attachment file.
- **Request:** Multipart form-data with the file data.
- **Response:** Details of the uploaded attachment.

### **3. Detach Attachment**

- **Endpoint:** **`DELETE /detach/{id}`**
- **Description:** Remove an attachment by its ID.
- **Request:** Path variable with the attachment ID.

### **4. Download Attachment**

- **Endpoint:** **`GET /download/{id}`**
- **Description:** Download an attachment by its ID.
- **Request:** Path variable with the attachment ID.
- **Response:** Attachment file for download.

### **5. View Attachment from Email**

- **Endpoint:** **`GET /view/{email}/{mailId}/{folderName}/{attachmentId}`**
- **Description:** View an attachment from a specific email.
- **Request:** Path variables with email, mail ID, folder name, and attachment ID.
- **Response:** Attachment file for viewing.

### **6. Delete Attachment from Email**

- **Endpoint:** **`DELETE /deleteAttachment/{email}/{mailId}/{attachmentId}`**
- **Description:** Delete an attachment from a specific email.
- **Request:** Path variables with email, mail ID, and attachment ID.

## **Contacts**

---

### **1. Create Contact**

- **Endpoint:** **`POST /contact/create/{userEmailAddress}/{contactName}/{contactEmailAddress}`**
- **Description:** Create a new contact for a user.
- **Request:** Path variables with user email, contact name, and contact email.
- **Response:** Confirmation message.

### **2. Rename Contact**

- **Endpoint:** **`POST /contact/rename/{userEmailAddress}/{contactName}/{contactEmailAddress}`**
- **Description:** Rename an existing contact for a user.
- **Request:** Path variables with user email, old contact name, new contact name, and contact email.
- **Response:** Confirmation message.

### **3. Reset Contact Email**

- **Endpoint:** **`POST /contact/reset/{userEmailAddress}/{contactEmailAddress}/{newContactEmailAddress}`**
- **Description:** Reset the email address of an existing contact for a user.
- **Request:** Path variables with user email, contact email, and new contact email.
- **Response:** Confirmation message.

### **4. Add Email to Contact**

- **Endpoint:** **`POST /contact/add/{userEmailAddress}/{contactEmailAddress}/{newContactEmailAddress}`**
- **Description:** Add an additional email to an existing contact for a user.
- **Request:** Path variables with user email, contact email, and new contact email.
- **Response:** Confirmation message.

### **5. Remove Email from Contact**

- **Endpoint:** **`DELETE /contact/remove/{userEmailAddress}/{contactEmailAddress}/{removedContactEmailAddress}`**
- **Description:** Remove an email from an existing contact for a user.
- **Request:** Path variables with user email, contact email, and removed contact email.
- **Response:** Confirmation message.

### **6. Delete Contact**

- **Endpoint:** **`DELETE /contact/delete/{userEmailAddress}/{contactEmailAddress}`**
- **Description:** Delete an existing contact for a user.
- **Request:** Path variables with user email and contact email.

### **7. Sort Contacts**

- **Endpoint:** **`GET /contact/sort/{userEmailAddress}/{order}`**
- **Description:** Sort contacts for a user based on the specified order (ascending or descending).
- **Request:** Path variables with user email and sort order.
- **Response:** Sorted list of contacts.

### **8. Search Contacts**

- **Endpoint:** **`GET /contact/search/{userEmailAddress}/{contactName}`**
- **Description:** Search for contacts for a user based on the provided contact name.
- **Request:** Path variables with user email and contact name.
- **Response:** List of contacts matching the search criteria.

### **9. Get All Contacts**

- **Endpoint:** **`GET /contact/get/{userEmailAddress}`**
- **Description:** Retrieve all contacts for a user.
- **Request:** Path variable with user email.
- **Response:** List of all contacts for the user.

## **Folders**

---

### **1. Create Folder**

- **Endpoint:** **`POST /folder/{email}/{folderName}`**
- **Description:** Create a new folder for a user.
- **Request:** Path variables with user email and folder name.

### **2. Delete Folder**

- **Endpoint:** **`DELETE /folder/{email}/{folderName}`**
- **Description:** Delete an existing folder for a user.
- **Request:** Path variables with user email and folder name.

### **3. Rename Folder**

- **Endpoint:** **`POST /folder/{email}/{oldName}/{newName}`**
- **Description:** Rename an existing folder for a user.
- **Request:** Path variables with user email, old folder name, and new folder name.

## **Mails**

---

### **1. Get Mails**

- **Endpoint:** **`GET /{email}/{folderName}`**
- **Description:** Retrieve emails for a user from a specific folder.
- **Request:** Path variables with user email and folder name.
- **Optional Query Parameters:** Sorting criteria and sorting order.

### **2. Filter Mails**

- **Endpoint:** **`GET /{email}/{folderName}/filter`**
- **Description:** Filter emails for a user from a specific folder based on criteria.
- **Request:** Path variables with user email and folder name.
- **Query Parameters:** List of filter criteria and filter value.

### **3. Send Mail**

- **Endpoint:** **`POST /compose`**
- **Description:** Send a new email or compose a draft.
- **Request:** JSON body with email details and optional parameters for draft.

### **4. Move Mail**

- **Endpoint:** **`POST /{email}/{fromFolder}/{toFolder}/{id}`**
- **Description:** Move an email from one folder to another.
- **Request:** Path variables with user email, source folder, destination folder, and email ID.

### **5. Delete Mail**

- **Endpoint:** **`DELETE /{email}/{folderName}/{id}`**
- **Description:** Delete an email from a specific folder for a user.
- **Request:** Path variables with user email, folder name, and email ID.

### **6. Create Draft**

- **Endpoint:** **`POST /createDraft/{email}`**
- **Description:** Create a draft email for a user.
- **Request:** Path variable with user email and JSON body with draft details.
