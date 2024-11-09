# VerseVibe - Find and Play Songs by Their Lyrics

## Table of Contents
- [About](#about)
- [Project Setup](#project-setup)
  - [Prerequisites](#prerequisites)
  - [Setup Elasticsearch and Kibana](#setup-elasticsearch-and-kibana)
- [Contributors](#contributors)

## About
Music discovery is often driven by remembering a song's lyrics rather than its title or artist. With over 5 million songs in the Genius Lyrics dataset, there is an immense potential to create a platform that allows users to search for tracks using any part of the lyrics. This project aims to develop a search engine that leverages this extensive dataset to match lyrics with songs and provide a direct link to stream the song on Spotify. By integrating two popular platforms, Genius and Spotify, this tool will offer users a seamless music discovery experience, empowering them to find and enjoy their favorite songs with ease.

## Project Setup
### Prerequisites
1. Docker
2. Java

### Setup Elasticsearch and Kibana
- Configure the environment variables in the [.env](./.env) file.
   - Set the passwords for the `elastic` and `kibana_system` users.
     ```sh
     # Password for the 'elastic' user (at least 6 characters)
     ELASTIC_PASSWORD=your_password
     
     # Password for the 'kibana_system' user (at least 6 characters)
     KIBANA_PASSWORD=your_password
     ```
   - Set the encryption key. You can generate an encryption key using the command: `openssl rand -base64 32`.
     ```sh
     ENCRYPTION_KEY="your_encryption_key"
     ```
- Start the services.
   ```sh
   docker-compose up --build -d
   ```
- Open the [Kibana dashboard](https://127.0.0.1:5601) locally.
   You can login to the dashboard using the username `elastic` and the password specified in the `ELASTIC_PASSWORD` environment variable.

**Note:  You can stop and start the services without removing the containers by running the commands given below.**
   ```sh
   docker-compose stop
   docker-compose start
   ```


## Contributors
- Mohammed Misran
- Satvik Tandon
- Varun Shelke
