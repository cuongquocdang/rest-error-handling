## Enabled in application.yml or application.properties
```
rest-error-handling:
  enabled: true
  rest-error-handling-file-name: 'rest-error-handling.json'
```

## Create rest-error-handling.json in the resource folder
```
[
  {
    "code": 5000,
    "codeDefinition": "UNKNOWN_ERROR",
    "codeMeaning": " Unknown Error",
    "type": "OTHER_ERROR",
    "hints": [
      "Contact developer team"
    ],
    "infoURL": "https://developer.com/errors#unknownerror"
  }
]
```

## Usage bean to get properties
```
private final Map<String, ErrorInfoDefinition> restErrorHandlingProperties;
```

## Exception For Handler
```
throw new RestErrorHandlingException(restErrorHandlingProperties.get("BUSINESS_ERROR"));
```