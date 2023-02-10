package com.sii.acadamy.token;

public record Token(String token) {
    public String toString() {
        return String.format("Provided token length: = %d%nGenerated token is: %s%n", token.length(), token);
    }
}
