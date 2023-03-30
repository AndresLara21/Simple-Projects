TITLE Fibonacci sequence with loop

; Prints a certain amount of Fibonacci numbers specified by user input
; written by Andres Lara
; March 18, 2023
; CSC 221-01

INCLUDE Irvine32.inc

.data
    num    DWORD ?                          ; declares an uninitialized variable num
    prompt BYTE "How many Fibonacci numbers (not inlcuding 0) would you like? Please select betwen 3 and 100 :  ",0

.code
main PROC
		  mov edx, OFFSET prompt            ; mov address of prompt into edx
          call WriteString                  ; call proc to write out what is pointed to by edx
          call ReadDec                      ; reads the input from the user, moves it to eax
          mov num, eax                      ; stores input into the variable num declared earlier
          mov eax, 1
		  mov ebx, 0
		  call CRLF 
          mov eax, 0
          call WriteDec 
          call CRLF 
          mov eax, 1 
          call WriteDec 
          call CRLF 
          mov ebx, 0
          DEC num
          mov ecx, num                      ; tells the loop how many times to run, num times
TOP:
	      mov edx, eax 
          add eax, ebx 
          mov ebx, edx 
          call WriteDec 
          call CRLF
		  
		  
		  loop TOP


	exit
main ENDP
END main