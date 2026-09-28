# AGENTS.md

## Project
This is a Java application.

## General Rules
- Write clean, readable, maintainable Java.
- Follow existing project conventions before introducing new patterns.
- Prefer simple solutions over unnecessary abstraction.
- Keep methods small and focused.
- Use meaningful names for classes, methods, and variables.
- Avoid duplicated code.
- Do not introduce dependencies unless they are necessary.
- Do not modify unrelated files.

## Java
- Use the Java version configured by the project.
- Prefer modern Java features when they improve readability.
- Use `final` where it improves clarity.
- Prefer immutable objects when practical.
- Use `Optional` appropriately; don't use it everywhere.
- Handle exceptions explicitly and meaningfully.
- Never silently catch exceptions.
- Do not use `System.out.println` for application logging; use the project's logging framework.

## Architecture
- Follow the existing architecture.
- Keep business logic out of controllers/UI layers.
- Keep classes focused on a single responsibility.
- Use dependency injection when the project already uses it.
- Do not create new layers or abstractions unless they provide a clear benefit.

## Testing
- Add or update tests when changing behavior.
- Prefer unit tests for business logic.
- Run the relevant tests after making changes.
- Do not remove or weaken existing tests just to make them pass.

## Before Changing Code
1. Inspect the relevant existing code.
2. Understand how the current implementation works.
3. Make the smallest reasonable change.
4. Run relevant tests/build checks.
5. Report what was changed and any remaining issues.

## Dependencies
- Check whether an existing dependency can solve the problem before adding a new one.
- Do not upgrade dependencies unless required.
- Never add a dependency without explaining why it is needed.

## Security
- Never hard-code passwords, API keys, tokens, or other secrets.
- Do not commit secrets to the repository.
- Validate external input where appropriate.
- Follow secure defaults.

## Git
- Do not reset, revert, or delete user changes without permission.
- Do not modify unrelated files.
- Keep changes focused and easy to review.
