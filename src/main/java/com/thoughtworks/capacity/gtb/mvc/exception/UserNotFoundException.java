package com.thoughtworks.capacity.gtb.mvc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.PrinterAbortException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNotFoundException extends Exception{
    private String msg;
}
