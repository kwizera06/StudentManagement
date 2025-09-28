# Spring Boot University Management System

A comprehensive university management system built with Spring Boot, featuring student registration, department management, and email notifications.

## 🚀 Quick Start with Docker

### Prerequisites
- Docker and Docker Compose installed
- Git

### Local Development

1. **Clone the repository**
   ```bash
   git clone <your-repo-url>
   cd springboot
   ```

2. **Run with Docker Compose**
   ```bash
   docker-compose up --build
   ```

3. **Access the application**
   - Application: http://localhost:8080
   - Health check: http://localhost:8080/actuator/health
   - PostgreSQL: localhost:5432

### Build Docker Image Manually

```bash
# Build the image
docker build -t spring-boot-app .

# Run the container
docker run -p 8080:8080 spring-boot-app
```

## 🌐 Deploy to Render

### Method 1: Using render.yaml (Recommended)

1. **Push your code to GitHub**
   ```bash
   git add .
   git commit -m "Add Docker configuration for Render deployment"
   git push origin main
   ```

2. **Connect to Render**
   - Go to [Render Dashboard](https://dashboard.render.com)
   - Click "New +" → "Blueprint"
   - Connect your GitHub repository
   - Render will automatically detect the `render.yaml` file

3. **Configure Environment Variables**
   - In the Render dashboard, go to your service
   - Navigate to "Environment" tab
   - Update sensitive values like database passwords and email credentials

### Method 2: Manual Setup

1. **Create a new Web Service**
   - Go to [Render Dashboard](https://dashboard.render.com)
   - Click "New +" → "Web Service"
   - Connect your GitHub repository

2. **Configure the service**
   - **Build Command**: Leave empty (Docker handles this)
   - **Start Command**: Leave empty (Docker handles this)
   - **Environment**: Docker
   - **Dockerfile Path**: `./Dockerfile`
   - **Docker Context**: `.`

3. **Set Environment Variables**
   ```
   SPRING_DATASOURCE_URL=your_postgresql_url
   SPRING_DATASOURCE_USERNAME=your_username
   SPRING_DATASOURCE_PASSWORD=your_password
   SPRING_MAIL_USERNAME=your_email@gmail.com
   SPRING_MAIL_PASSWORD=your_app_password
   SERVER_PORT=10000
   ```

## 📁 Project Structure

```
springboot/
├── src/main/java/com/example/spring/
│   ├── Application.java                 # Main application class
│   ├── controller/                     # REST controllers
│   ├── dto/                           # Data Transfer Objects
│   ├── entity/                        # JPA entities
│   ├── repository/                    # Data repositories
│   └── service/                       # Business logic services
├── src/main/resources/
│   └── application.properties         # Application configuration
├── Dockerfile                         # Docker configuration
├── docker-compose.yml                 # Local development setup
├── render.yaml                        # Render deployment config
├── .dockerignore                      # Docker ignore file
└── pom.xml                           # Maven configuration
```

## 🔧 Configuration

### Environment Variables

The application supports the following environment variables:

| Variable | Description | Default |
|----------|-------------|---------|
| `SPRING_DATASOURCE_URL` | Database connection URL | PostgreSQL URL from properties |
| `SPRING_DATASOURCE_USERNAME` | Database username | From properties |
| `SPRING_DATASOURCE_PASSWORD` | Database password | From properties |
| `SPRING_MAIL_USERNAME` | Email username | From properties |
| `SPRING_MAIL_PASSWORD` | Email app password | From properties |
| `SERVER_PORT` | Application port | 8080 |
| `SPRING_PROFILES_ACTIVE` | Active profile | production |

### Database

The application uses PostgreSQL and includes:
- Student management
- Department management
- Course enrollment
- Library management
- Hostel management
- User authentication

### Email Service

Configured for Gmail SMTP with:
- Student registration notifications
- OTP verification
- System notifications

## 🏥 Health Checks

The application includes Spring Boot Actuator for health monitoring:
- Health endpoint: `/actuator/health`
- Info endpoint: `/actuator/info`

## 🔒 Security Notes

- Database credentials are stored in environment variables
- Email credentials should be secured in production
- The application runs as a non-root user in Docker
- Health checks are configured for container orchestration

## 📝 API Endpoints

- `POST /api/students` - Register new student
- `GET /api/students` - Get all students
- `POST /api/departments` - Create department
- `GET /api/departments` - Get all departments
- `POST /api/verify-otp` - Verify OTP

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Failed**
   - Check database URL and credentials
   - Ensure PostgreSQL is running
   - Verify network connectivity

2. **Email Service Not Working**
   - Verify Gmail app password
   - Check SMTP settings
   - Ensure 2FA is enabled on Gmail

3. **Docker Build Fails**
   - Check Dockerfile syntax
   - Verify all dependencies in pom.xml
   - Ensure Java 21 is available

### Logs

View application logs:
```bash
# Docker Compose
docker-compose logs -f spring-app

# Docker
docker logs <container-id>
```

## 📞 Support

For issues and questions, please check the application logs and ensure all environment variables are properly configured.
