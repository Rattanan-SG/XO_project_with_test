*** Setting ***
Library     SeleniumLibrary

*** Variables ***
${URL}    http://localhost:8080/test-xo-with-robotframework/index.jsp
${BROWSER}    chrome

*** Test Cases ***
player2 เป็นผู้ชนะ ในแนวนอนแถวที่ 1
    เปิดหน้าเว็บเกมox
    player1 คลิกเลือกตำแหน่ง แถว2คอลัมน์1
    player2 คลิกเลือกตำแหน่ง แถว1คอลัมน์1
    player1 คลิกเลือกตำแหน่ง แถว2คอลัมน์2
    player2 คลิกเลือกตำแหน่ง แถว1คอลัมน์2
    player1 คลิกเลือกตำแหน่ง แถว3คอลัมน์2
    player2 คลิกเลือกตำแหน่ง แถว1คอลัมน์3
    แสดงผลว่า player2 ได้ 1 คะแนน

*** keyword ***
เปิดหน้าเว็บเกมox
    Open Browser    ${URL}    ${BROWSER}

player1 คลิกเลือกตำแหน่ง แถว2คอลัมน์1
    Click Element    id=R2_C1
    Wait Until Element Contains    id=R2_C1    X

player2 คลิกเลือกตำแหน่ง แถว1คอลัมน์1
    Click Element    id=R1_C1
    Wait Until Element Contains    id=R1_C1    O

player1 คลิกเลือกตำแหน่ง แถว2คอลัมน์2
    Click Element    id=R2_C2
    Wait Until Element Contains    id=R2_C2    X

player2 คลิกเลือกตำแหน่ง แถว1คอลัมน์2
    Click Element    id=R1_C2
    Wait Until Element Contains    id=R1_C2    O

player1 คลิกเลือกตำแหน่ง แถว3คอลัมน์2
    Click Element    id=R3_C2
    Wait Until Element Contains    id=R3_C2    X

player2 คลิกเลือกตำแหน่ง แถว1คอลัมน์3
    Click Element    id=R1_C3
    Wait Until Element Contains    id=R1_C3    O

แสดงผลว่า player2 ได้ 1 คะแนน
    Wait Until Element Contains    id=player2Score    1

ปิดหน้าเว็บ
    Close Browser