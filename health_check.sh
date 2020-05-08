Timeout=120
server_endpoint="http://localhost:8080/"
check=""

function check_server() {
  # Get the status code for requesting to the server
  check=$(curl -s -o /dev/null -w "%{http_code}" $server_endpoint)
}

function timeout_monitor() {
  # Start the the timeout monitor
  sleep "$Timeout"
  echo "Health check timed out. Service is offline."
  kill "$1"
}

# Initial server check
check_server

# Start timeout monitor
timeout_monitor "$$" &

# Get the PID of the timeout monitor
Timeout_monitor_pid=$!

# Keep checking the server until it is up
while [[ $check != 200 && $check != 403 ]]
do
  check_server
done

# Service is online
echo "Service is online"
exit 0

kill "$Timeout_monitor_pid"

