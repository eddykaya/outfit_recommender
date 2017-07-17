# An awesome outfit recommender

This awesome outfit recommender tells you what clothes to wear. It checks the temperature in your city and gives you a outfit recommendation based on it.

## Building and running
### Prerequisites
This service ships with a Dockerfile so you can start quickly, but you need a working docker installation. Also, you need to sign up on [Openweathermap](http://openweathermap.com/) and request a free API Key

### Building
1. Checkout the repository
2. run ```mvn clean package docker:package -Pbuild-docker-image```

### Running
1. In order to run the service, just enter ```docker run -d -p 8080:8080 -e OPENWEATHER_API_KEY=<your-api-key> docker.tss.de/outfit_recommendation:0.0.1-SNAPSHOT```
#### available environment variables
As you can see, there are some environment variables available to configure the service:
* OPENWEATHER_API_KEY: your own API key for the openweathermap API
###### if you run the service behind a proxy:
* PROXY_HOST: the proxy host, e.g. proxy.example.com
* PROXY_PORT: the proxy port, e.g. 8090
* PROXY_USER: the proxy username if you have authentication
* PROXY_PASS: the proxy password

### Usage
#### API Endpoint
The service has one REST HTTP Endpoint, just enter http://localhost:8080/weather/outfit?zipCode=<your_zip_code> to retrieve an outfit recommendation

#### Response
The service response looks like the following:
```javascript
{
    "currentTemperature": 24.65,
    "outfitLevel": "TWO"
}
```
