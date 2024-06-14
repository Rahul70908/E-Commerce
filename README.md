# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

<b>This is a Spring Boot Multi-Module Project which consist of various modules like:</b>
<p>User-Service<br>Notification-Service</p>

<div>
<p>User-Service:
<a>http://localhost:8080/swagger-ui/index.html</a></p>

<p>Notification-Service:
<a>http://localhost:8081/swagger-ui/index.html</a></p>
</div>

This is a Basic User Registration Service.

## [1.0.0-SNAPSHOT]

- Added a feature where User can Register either through Email or Phone.
- Added UserService and NotificationService for Sending OTP or Mail.
  (As of Now Only Mail OTP Feature is implemented)
- The OTP generated will only be valid for 5 minutes
- Added Swagger Documentation