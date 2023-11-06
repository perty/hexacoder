package se.artcomputer.edu.hexacoder.adapter.in.rest.common;

public record ErrorEntity(int httpStatus, String errorMessage) {}