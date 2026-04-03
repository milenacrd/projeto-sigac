# Upgrade Plan: sigac (20260327130527)

- **Generated**: March 27, 2026
- **HEAD Branch**: N/A
- **HEAD Commit ID**: N/A

**Note:** The project is not version-controlled during this upgrade.

## Available Tools

**JDKs**

- JDK 21: C:\Program Files\Eclipse Adoptium\jdk-21.0.6.7-hotspot\bin (current project JDK, used by step 2)

- JDK 25: **<TO_BE_INSTALLED>** (required by steps 3 and 4)

**Build Tools**

- Maven Wrapper: 3.9.14 → **<TO_BE_UPGRADED>** to 4.0+ (current version incompatible with Java 25)

## Guidelines



> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred. <!-- this note is for users, NEVER remove it -->

## Options

- Working branch: appmod/java-upgrade-20260327130527
- Run tests before and after the upgrade: true <!-- user specified, NEVER remove it -->

## Upgrade Goals

- Upgrade Java from 21 to 25

### Technology Stack

| Technology/Dependency | Current | Min Compatible | Why Incompatible |
| ---------------------- | ------- | -------------- | ---------------- |
| Java                   | 21      | 25             | User requested   |
| Spring Boot            | 4.0.5   | 4.0.5          | -                |
| Maven Wrapper          | 3.9.14  | 4.0+           | Maven 3.9.x does not support Java 25 |
| maven-compiler-plugin  | default | default        | -                |
| spring-boot-maven-plugin | default | default      | -                |
| MySQL Connector J      | default (from Spring Boot) | default | - |
| Lombok                 | default | default        | -                |

| Technology/Dependency | Current | Min Compatible | Why Incompatible |
| --------------------- | ------- | -------------- | ---------------- |

### Derived Upgrades

- Java: 21 → 25 (user requested)

- Maven Wrapper: 3.9.14 → 4.0+ (required for Java 25 support)

## Upgrade Steps

- Step 1: Setup Environment

  - **Rationale**: Install required JDK 25 and upgrade Maven Wrapper to 4.0+ for Java 25 support.

  - **Changes to Make**:

    - [ ] Install JDK 25

    - [ ] Upgrade Maven Wrapper to 4.0+

  - **Verification**:

    - Command: #appmod-list-jdks, check Maven wrapper version

    - Expected: JDK 25 installed, Maven 4.0+ available

- Step 2: Setup Baseline

  - **Rationale**: Establish pre-upgrade compile and test results.

  - **Changes to Make**:

    - [ ] Run baseline compilation

    - [ ] Run baseline tests

  - **Verification**:

    - Command: mvn clean test-compile -q && mvn clean test -q

    - JDK: JDK 21

    - Expected: Document SUCCESS/FAILURE, test pass rate

- Step 3: Upgrade Java Version

  - **Rationale**: Update project to use Java 25.

  - **Changes to Make**:

    - [ ] Update <java.version> to 25 in pom.xml

  - **Verification**:

    - Command: mvn clean test-compile -q

    - JDK: JDK 25

    - Expected: Compilation SUCCESS

- Step 4: Final Validation

  - **Rationale**: Verify all goals met, project compiles and tests pass with Java 25.

  - **Changes to Make**:

    - [ ] Run full test suite

  - **Verification**:

    - Command: mvn clean test -q

    - JDK: JDK 25

    - Expected: Compilation SUCCESS + 100% tests pass

## Key Challenges

- **Java 25 Compatibility**

  - **Challenge**: Java 25 is a new LTS release; potential compatibility issues with dependencies.

  - **Strategy**: Test compilation and execution thoroughly.

- **Maven 4.0 Upgrade**

  - **Challenge**: Major version upgrade; potential plugin incompatibilities.

  - **Strategy**: Update wrapper and verify build works.

## Plan Review

The plan is complete and feasible. Upgrading from Java 21 to 25 with Maven wrapper upgrade. No known limitations.
