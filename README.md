[![](https://jitpack.io/v/jaceed/Extender.svg)](https://jitpack.io/#jaceed/Extender)

# Extender
Helpful kotlin extension tools

## Usage

Use `gradle`

First, add it in your root build.gradle at the end of repositories:

```gradle
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Then, add the dependency:

```gradle
    dependencies {
	        implementation 'com.github.jaceed:extender:1.0.0'
	}
```

Or use `maven` with the following two contents instead of the above

```gradle
    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

and

```gradle
    <dependency>
	    <groupId>com.github.jaceed</groupId>
	    <artifactId>extender</artifactId>
	    <version>1.0.0</version>
	</dependency>
```


