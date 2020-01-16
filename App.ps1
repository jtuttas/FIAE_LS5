$data=Invoke-RestMethod -Uri "http://192.168.178.87:8080/get?pressure"
Write-Host "Pressure: $($data.buffer.pressure.buffer) mBar"