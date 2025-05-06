#!/bin/bash

# Exit immediately if any command fails
set -e

# Navigate to the Maven project directory
cd simpleTaskManagerProject

# Build the project and create the JAR file
mvn clean package

# Copy the built JAR to the website downloads directory
cp target/SimpleTaskManager-1.0-SNAPSHOT.jar ../website/downloads/taskmanager.jar

# Run the JAR file to demonstrate that it works
java -jar target/SimpleTaskManager-1.0-SNAPSHOT.jar &

# Open the HTML page in the default browser
xdg-open ../website/index.html || open ../website/index.html

# Keep the terminal window open (optional)
read -p "Press enter to continue..."
