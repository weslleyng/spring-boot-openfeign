package dev.weslley.model;

import java.util.List;

public record ResponseData<T>(List<T> data) {
}
