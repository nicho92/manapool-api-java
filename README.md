# manapool-api-java
java api for manapool.com

**Import via maven**

```xml
<dependency>
    <groupId>com.github.nicho92</groupId>
    <artifactId>manapool-api-java</artifactId>
    <version>0.0.1</version>
</dependency>
```

**USAGE**

```java
var service = new InventoryService(<YOUR EMAIL>,<YOUR TOKEN API>);

		service.getSellerInventory().forEach(e->{
			
			System.out.println(e.getProduct() + " " +  e.getPriceValue());
						
		});
```
