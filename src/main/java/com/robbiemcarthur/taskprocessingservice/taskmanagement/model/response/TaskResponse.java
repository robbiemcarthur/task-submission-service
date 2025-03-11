package com.robbiemcarthur.taskprocessingservice.taskmanagement.model.response;

import com.fasterxml.jackson.annotation.JsonValue;

public record TaskResponse(@JsonValue
                           String description){}