$data=Invoke-RestMethod -Uri "https://api.openweathermap.org/data/2.5/weather?q=Hanover,de&appid=4727c8383bacbff7ac85de94ec48c85c"
Write-Host "Temperatur: $($data.main.temp) K"