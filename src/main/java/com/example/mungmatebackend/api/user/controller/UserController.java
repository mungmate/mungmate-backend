package com.example.mungmatebackend.api.user.controller;

import com.example.mungmatebackend.api.user.dto.request.UserReq;
import com.example.mungmatebackend.api.user.dto.response.UserRes;
import com.example.mungmatebackend.domain.user.service.UserService;
import com.example.mungmatebackend.global.config.error.dto.ErrorRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "User", description = "유저 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

  private final UserService userService;

  @Operation(summary = "User 로그인 API")
  @ApiResponses(value = {
          @ApiResponse(
                  responseCode = "200",
                  description = "로그인 성공",
                  content = @Content(schema = @Schema(implementation = UserRes.class))
          ),
          @ApiResponse(
                  responseCode = "404",
                  description = "이메일 불일치",
                  content = @Content(schema = @Schema(implementation = ErrorRes.class))
          ),
          @ApiResponse(
                  responseCode = "401",
                  description = "패스워드 불일치",
                  content = @Content(schema = @Schema(implementation = ErrorRes.class))
          )
  })
  @PostMapping("/login")
  public ResponseEntity<UserRes> postUser(@Valid @RequestBody UserReq user) {
    return ResponseEntity.ok(userService.login(user));
  }
}
