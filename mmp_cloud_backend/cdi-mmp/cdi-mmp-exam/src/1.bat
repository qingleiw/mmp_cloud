@echo off
chcp 65001 >nul
setlocal enabledelayedexpansion

rem 使用方法: 1.bat [目录路径] [r]
rem 添加参数 r 表示递归搜索子目录
rem 例如: 1.bat . r

set "DIR=%~1"
if "%DIR%"=="" set "DIR=."

set "RECURSIVE=%~2"
set count=0
set found=0

echo 正在搜索目录: %DIR%
echo.

if /i "%RECURSIVE%"=="r" (
    echo [递归模式] 搜索所有子目录...
    echo.
    
    for /r "%DIR%" %%f in (*Qualification*) do (
        set /a found+=1
        set "filepath=%%f"
        set "filename=%%~nxf"
        set "dirpath=%%~dpf"
        set "newname=!filename:Qualification=!"
        
        echo 找到: !filename!
        
        if exist "!dirpath!!newname!" (
            echo   [跳过] !newname! 已存在
        ) else (
            ren "%%f" "!newname!"
            if !errorlevel! equ 0 (
                echo   [成功] 重命名为: !newname!
                set /a count+=1
            ) else (
                echo   [失败] 重命名失败
            )
        )
        echo.
    )
) else (
    echo [当前目录模式] 只搜索当前目录...
    echo.
    
    for %%f in ("%DIR%\*Qualification*") do (
        set /a found+=1
        set "filename=%%~nxf"
        set "newname=!filename:Qualification=!"
        
        echo 找到: !filename!
        
        if exist "%DIR%\!newname!" (
            echo   [跳过] !newname! 已存在
        ) else (
            ren "%%f" "!newname!"
            if !errorlevel! equ 0 (
                echo   [成功] 重命名为: !newname!
                set /a count+=1
            ) else (
                echo   [失败] 重命名失败
            )
        )
        echo.
    )
)

echo ================================
if !found! equ 0 (
    echo 未找到包含 "Qualification" 的文件
    echo.
    echo 提示:
    echo - 确认当前目录是否正确
    echo - 如需搜索子目录，请使用: %~nx0 . r
) else (
    echo 找到 !found! 个文件
    echo 成功重命名 !count! 个文件
)
echo ================================

pause