#!/bin/bash

echo "Check if the Funmanagment API container is running... "

RUNNING_CONTAINER=$(docker ps --filter 'name=maanuy-dev' --format '{{.ID}}')

# If the fundmanagement-mobile-rest containter is running
if [ -n "$RUNNING_CONTAINER" ]; then
    echo " "$RUNNING_CONTAINER" is running..."
    $(docker stop "$RUNNING_CONTAINER") 2>/dev/null
    echo " "$RUNNING_CONTAINER" successfully stopped"
    $(docker rm "$RUNNING_CONTAINER") 2>/dev/null

    echo "Building image, start in 👇 :point_down:"
    $(docker build --build-arg SPRING_PROFILES_ACTIVE=dev -t maanuy-dev:1.0.0 .) 2>/dev/null

    # Running image
    echo "running image!"
    # Count up for 5 seconds

    $(docker run -d --name maanuy-dev --network dbn -p 1016:8081 -e SPRING_PROFILES_ACTIVE=dev maanuy-dev:1.0.0) 2>/dev/null

    echo "🚀🚀The container has been executed successfully.🚀🚀"
# If none of the above conditions are met, the number must be less than 10
else
    echo "No container running at the moment"

    echo "⏰ Building image, start in ⏰"
    # Count up for 5 seconds
    $(docker build -t maanuy-dev:1.0.0 .) 2>/dev/null

    # Running image
    echo "⏰⏰ running image! ⏰⏰"
    # Count up for 5 seconds
    # Running image
    $(docker run -d --name maanuy-dev --network dbn -p 1016:8081 -e SPRING_PROFILES_ACTIVE=dev maanuy-dev:1.0.0) 2>/dev/null

    echo "🚀🚀The container has been executed successfully.🚀🚀"
fi
