call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo There were errors
goto fail

:runbrowser
start chrome "http://localhost:8080/crud/v1/task/getTasks"
goto end

:end
echo Check your browser.