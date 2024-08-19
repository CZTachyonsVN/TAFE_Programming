---
tags:
  - notes
  - "#osi"
  - "#idempotency"
  - "#cors"
  - "#crossoriginresourcesharing"
unit: WebData
semester: 2
week: 6
---
## [OSI Model](../TeachingContent/OSI_model.pdf)
## [Idempotency](../TeachingContent/Idempotency.pdf)
- If an action is done twice within a short timeframe, act as if it is only being invoked once.
- Avoids unintentional behaviour.
# [Cross Origin Resource Sharing](../TeachingContent/Cross_Origin_Resource_Sharing.pdf)
- Security measure to stop execution of code from unauthorised origins.
### Same Origin Policy
- Browser stops cross site script execution
- Intended cross site interactions cannot work (e.g., embedded media)
### CORS
- Web developer sets the rules of how their website can be interacted with.
	- Whitelist of domains.
	- Specific allowed API calls.
	- Combination of the two.
- Browser enforces the rules.
# Attack vectors
## Cross Site Request Forgery

- Notes: [Cross-site Scripting](Injection_Vulnerability#Cross-site%20Scripting) in [Injection_Vulnerability](../../01_IntegrateDatabases/01_Notes/Injection_Vulnerability.md)
- A fake site that has the real website embedded inside it.
## DDOS
- Overwhelming a server with high amount of traffic
# Pre-Flight
- "Pre-request" that asks for permission before sending the request itself.
- Most browsers will do a pre-flight for all  requests.
- 204 response that only contains a header with the rules
	- Browser will decide whether the requests aligns with the rules