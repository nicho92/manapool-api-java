# manapool-api-java

Java client library for the [Mana Pool](https://manapool.com) API. The library wraps common buyer, seller, inventory, price, card, account, and order endpoints in Java model classes.

## Requirements

- Java 13 or newer
- Maven 3.x
- A Mana Pool account email and API token

## Installation

Add the Maven dependency to your project:

```xml
<dependency>
    <groupId>com.github.nicho92</groupId>
    <artifactId>manapool-api-java</artifactId>
    <version>0.0.11</version>
</dependency>
```

## Quick start

Create a `ManaPoolAPIService` with your Mana Pool email address and API token:

```java
import org.api.manapool.services.ManaPoolAPIService;

public class Example {
    public static void main(String[] args) throws Exception {
        var service = new ManaPoolAPIService("you@example.com", "your-api-token");

        service.getSellerInventory().forEach(item -> {
            System.out.println(
                item.getProduct().getName() + " - " +
                item.getQuantity() + " copies at " +
                item.getPriceValue()
            );
        });
    }
}
```

## Configuration file authentication

You can also load credentials from a Java properties file:

```properties
EMAIL=you@example.com
TOKEN=your-api-token
```

```java
import java.io.File;
import org.api.manapool.services.ManaPoolAPIService;

var service = new ManaPoolAPIService(new File(System.getProperty("user.home") + "/manapool.properties"));
```

## Common operations

### Look up card information

```java
var card = service.cardInfo("Lightning Bolt");
System.out.println(card.getName());
```

For multiple cards:

```java
var cards = service.cardInfo(List.of("Lightning Bolt", "Counterspell"));
```

### Read seller inventory

```java
var inventory = service.getSellerInventory();
inventory.forEach(item -> System.out.println(item.getProduct().getName()));
```

Use pagination when you only need a subset:

```java
var firstPage = service.getSellerInventory(50, 0);
```

Fetch a specific inventory entry by product type and Scryfall ID:

```java
import org.api.manapool.model.enums.EnumType;

var item = service.getSellerInventoryById(
    EnumType.SINGLE,
    "df9ec379-bcef-4607-a6e4-aa194e09bc73"
);
```

### Add inventory items

```java
import java.util.List;
import org.api.manapool.model.ProductQueryEntry;
import org.api.manapool.model.enums.EnumCondition;
import org.api.manapool.model.enums.EnumFinish;
import org.api.manapool.model.enums.EnumLangages;

var entry = new ProductQueryEntry(
    "df9ec379-bcef-4607-a6e4-aa194e09bc73",
    EnumLangages.EN,
    EnumFinish.NF,
    EnumCondition.NM,
    2.50,
    4
);

var updatedInventory = service.addInventoryItems(List.of(entry));
```

### Update or delete inventory items

```java
entry.setPrice(3.00);
entry.setQuantity(2);
var updatedItem = service.updateInventoryItems(entry);

var deletedItem = service.deleteInventoryItems(entry);
```

> **Warning:** `clearSellerInventory()` deletes every item from the seller inventory.

```java
service.clearSellerInventory();
```

### Prices

```java
var singles = service.listSinglesPrices();
var sealed = service.listSealedPrices();
var variants = service.listVariantsPrices();
```

### Orders

```java
var soldOrders = service.listSellsOrders(50, 0);
var boughtOrders = service.listBoughtOrders(50, 0);

var soldOrder = service.getSellsOrderById(soldOrders.get(0).getId());
var boughtOrder = service.getBoughtOrderById(boughtOrders.get(0).getId());
```

### Account and buyer credit

```java
var account = service.userAccount();
var credit = service.userCredits();
```

## Supported enums

### Conditions

| Enum | Meaning |
| --- | --- |
| `NM` | Near Mint |
| `LP` | Lightly Played |
| `MP` | Moderately Played |
| `HP` | Heavily Played |
| `DMG` | Damaged |

### Finishes

| Enum | Meaning |
| --- | --- |
| `NF` | Non-Foil |
| `FO` | Foil |
| `EF` | Etched Foil |

### Languages

| Enum | Meaning |
| --- | --- |
| `EN` | English |
| `JA` | Japanese |
| `FR` | French |
| `IT` | Italian |
| `DE` | German |
| `ES` | Spanish |
| `AR` | Arabic |
| `CS` | Chinese Simplified |
| `CT` | Chinese Traditional |
| `EL` | Ancient Greek |
| `HE` | Hebrew |
| `KO` | Korean |
| `LA` | Latin |
| `PH` | Phyrexian |
| `PT` | Portuguese (Brazil) |
| `RU` | Russian |
| `SA` | Sanskrit |

### Product types

| Enum | Mana Pool product type |
| --- | --- |
| `SINGLE` | `mtg_single` |
| `SEALED` | `mtg_sealed` |

## Development

Clone the repository and build it with Maven:

```bash
git clone https://github.com/nicho92/manapool-api-java.git
cd manapool-api-java
mvn test
```

Create a local package:

```bash
mvn package
```

The `src/test/java/org/api/manapool/tests/Testers.java` file is a manual smoke-test helper that expects `~/manapool.properties` with `EMAIL` and `TOKEN` values.

## License

This project is licensed under the Apache License, Version 2.0.
