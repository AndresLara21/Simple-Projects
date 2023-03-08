; Program Description: a simple name input program
; CSC 121-01
; Author: Andres Lara
; Creation Date: 03/07/2023


include irvine32.inc
.data
   prompt BYTE "What should I call you: ",0
   greeting BYTE "Hello "
   username BYTE 128 DUP(0)
.code
   main PROC
      mov edx, offset prompt
      call WriteString
      mov edx, offset username
      mov ecx, 127
      call ReadString
      mov edx, offset greeting
      call WriteString
      exit
   main ENDP
   END main