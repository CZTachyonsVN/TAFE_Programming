---
tags:
  - notes
unit: RESTAPI
semester: 2
week: 1
---
# JSON for request and responses
# Use nouns for endpoint paths
# Names for collections are plural
# Use status codes for error handling
[Internet Standard: RFC 9110](https://httpwg.org/specs/rfc9110.html#overview.of.status.codes) #statuscodes
100 - 199 = Informational responses
200 - 299 = Successful responses
300 - 399 = Redirection messages
400 - 499 = Client error
500 - 599 = Server error
# Show relationship by nesting endpoints
> [!warning]
> It is discouraged if you have reached more than three levels deep.
# Use filtering, sorting, and pagination
To avoid processing needless data (i.e. the entire database).
# Use Secure Socket Layer (SSL)
HTTPS should be the default protocol for security.
# Secure communication
- Make communication private.
- Limit access to resources to only satisfy the request.
# Maintain a proper versioning system
[Postman article](https://www.postman.com/api-platform/api-versioning/)
First number = major version
Second number = minor version
Third number = path version
e.g., `https://samplesite.com/v1/`
