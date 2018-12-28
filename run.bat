for /F "tokens=1,2,3,4,5" %%A in ('"netstat -ano| find "8088""') DO (taskkill /pid %%E -t -f)

echo 'run.bat: kill done'

mvn spring-boot:run