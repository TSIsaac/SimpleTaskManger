# Simple Task Manager - Project 2

## Overview

This project is a Java-based task manager application built using JavaFX and Maven. It includes a companion website where users can download the executable `.jar` file. The application and website are prepared for deployment in a cloud environment (e.g., Azure or AWS).

---

## Contents

- `simpleTaskManagerProject/`: Java Maven project source code  
- `website/`: Static website containing a download page  
- `setup.sh`: Script to automate building, testing, and launching the application and website  
- `README.md`: Documentation for setup and deployment  

---

## Setup Instructions

### Prerequisites

- Java 11 or later installed  
- Maven installed  
- A Bash shell (for running `setup.sh`) or terminal emulator  
- Git (optional)  
- Node.js (optional, if extending website functionality)  

---

### Running the Setup Script

1. Open a terminal.  
2. Navigate to the project root directory.  
3. Run the setup script:

```bash
chmod +x setup.sh
./setup.sh
```

This script will:

- Navigate to the Java project directory  
- Compile the project and create an executable `.jar` file  
- Move the `.jar` file to `website/downloads/`  
- Launch the Java application  
- Open the website's `index.html` file in your browser  

---

## Website Deployment (Manual)

1. Upload the `website/` folder to a static hosting service (e.g., Azure Web App, GitHub Pages, or AWS S3).  
2. Ensure the `taskmanager.jar` file remains in the `downloads/` folder.  
3. Once deployed, share the public URL.  

---

## Deployment Notes (Optional Script Automation)

You may automate website deployment by adding these steps to your `setup.sh` (optional for +5 bonus points):

- Use `az webapp up` or AWS CLI to deploy `website/`  
- Include deployment logs and screenshot in your final submission  

---

## Screenshots

Include the following in your submission:

- Screenshot of the website deployed and accessible via cloud (with visible URL)  
- Screenshot of the application running  
- Screenshot of the `.jar` downloaded from the cloud  

---

## Cleanup

Don’t forget to delete or shut down any cloud services used to avoid unexpected charges.
