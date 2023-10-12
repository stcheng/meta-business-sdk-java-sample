# Use the official Maven image, which includes Java
FROM maven:3.8.1-openjdk-11

# Set the working directory inside the container
WORKDIR /app

# Keep container up and running for development
CMD tail -f /dev/null
