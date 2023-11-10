# **Ecommerce-Webpage-Testing-Framework-with-Selenium-Java-TestNG**

This repository contains the development of a Selenium - Java - TestNG project. The project is designed to test an ecommerce webpage on the Chrome browser. The testing scenarios implemented include:

- Purchase a product: This scenario follows the complete buy flow of the page, selecting a random product, adding it to the cart, adding the personal data, and checking that you are successfully arriving at the “Thank you for your purchase” page.
- Removing elements of the shopping cart: This scenario adds 3 different elements to the shopping cart, enters the cart page, removes them, and checks the shopping cart is empty.
- Logout: This scenario tries to log out and checks if you are correctly redirected to the login page.

The project follows the Page Object Model and uses the Page Factory for managing elements. Before annotations are used to manage preconditions.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You will need:

- Java Development Kit (JDK)
- Selenium WebDriver
- TestNG
- Chrome Browser
