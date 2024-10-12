# Design Patterns Course

This repository contains examples and explanations for various design patterns in software development. The design patterns are categorized into three main types:

- **Creational Patterns**
- **Structural Patterns**
- **Behavioral Patterns**

Each category is represented by a separate branch in the repository, managed as a Git submodule.

---

## How to Work with This Repository

### 1. Cloning the Repository with Submodules

When you clone this repository, make sure to initialize and update the submodules:

```bash
git clone --recurse-submodules https://github.com/BishoySedra/Design_Patterns_Course.git
```

Alternatively, if you’ve already cloned the repo, you can initialize and update the submodules like this:

```bash
git submodule init
git submodule update
```

### 2. Accessing the Design Pattern Categories

Each design pattern category is available in a separate directory:

- `creational_patterns/`: Contains design patterns that deal with object creation mechanisms.
- `structural_patterns/`: Contains patterns that focus on the composition of classes and objects.
- `behavioral_patterns/`: Contains patterns that deal with communication between objects.

Navigate to any of these directories to explore the patterns in that category.