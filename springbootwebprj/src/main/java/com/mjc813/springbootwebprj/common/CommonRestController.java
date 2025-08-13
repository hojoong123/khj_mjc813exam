package com.mjc813.springbootwebprj.common;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

public class CommonRestController {
    protected ResponseEntity<ResponseDto> getResponseEntity( ResponseEnumCode resultCode
            , String message
            , Object resultData ) {
        if ( resultCode == ResponseEnumCode.SUCCESS ) {
            return ResponseEntity.ok().body(
                    ResponseDto.builder().resultCode(resultCode).message(message).resultData(resultData).build()
            );
        } else {
            return ResponseEntity.status(500).body(
                    ResponseDto.builder().resultCode(resultCode).message(message).resultData(resultData).build()
            );
        }
    }

    protected ResponseEntity<ResponseDto> getResponseEntity(
            Logger log
            , Throwable th
            , ResponseEnumCode resultCode
            , String message
            , Object resultData ) {
        if ( resultCode == ResponseEnumCode.SUCCESS ) {
            return ResponseEntity.ok().body(
                    ResponseDto.builder().resultCode(resultCode).message(message).resultData(resultData).build()
            );
        } else {
            log.error(th.toString());
            return ResponseEntity.status(500).body(
                    ResponseDto.builder().resultCode(resultCode).message(message).resultData(resultData).build()
            );
        }
    }
}
