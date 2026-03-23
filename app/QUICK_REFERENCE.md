# Autofill Quick Reference

> TL;DR for busy developers

## Standard Fields (Use These!)

### XML
```xml
<EditText
    android:autofillHints="emailAddress"
    android:inputType="textEmailAddress" />
```

### Compose
```kotlin
OutlinedTextField(
    modifier = Modifier.semantics {
        contentType = ContentType.EmailAddress
    }
)
```

## Custom Fields

### XML
```xml
<EditText
    android:autofillHints="Bank name"
    android:inputType="text" />
```

### Compose
```kotlin
OutlinedTextField(
    modifier = Modifier.semantics {
        contentDescription = "Bank name"
    }
)
```

## Most Common Standard Hints

| What | XML | Compose |
|------|-----|---------|
| Email | `emailAddress` | `ContentType.EmailAddress` |
| Phone | `phoneNumber` | `ContentType.PhoneNumber` |
| Name | `personName` | `ContentType.PersonFullName` |
| First Name | `personFirstName` | `ContentType.PersonFirstName` |
| Last Name | `personLastName` | `ContentType.PersonLastName` |
| Address | `addressStreet` | `ContentType.AddressStreet` |
| City | `addressLocality` | `ContentType.AddressLocality` |
| State | `addressRegion` | `ContentType.AddressRegion` |
| ZIP | `postalCode` | `ContentType.PostalCode` |
| Card Number | `creditCardNumber` | `ContentType.CreditCardNumber` |
| Card Exp Month | `creditCardExpirationMonth` | `ContentType.CreditCardExpirationMonth` |
| Card Exp Year | `creditCardExpirationYear` | `ContentType.CreditCardExpirationYear` |
| CVV | `creditCardSecurityCode` | `ContentType.CreditCardSecurityCode` |

## Golden Rules

1. ✅ **Use standard hints when available** (emailAddress, phoneNumber, etc.)
2. ✅ **Use descriptive strings for custom fields** ("Bank name", not "field1")
3. ✅ **Match inputType to field type** (email → textEmailAddress)
4. ❌ **Don't use generic names** (field1, input, value)
5. ✅ **Test with real autofill services**

## Testing

1. Enable autofill service: **Settings** → **System** → **Autofill service**
2. Add test data to autofill service
3. Open your app and tap form fields
4. Check for autofill suggestions

## Debug

```bash
adb logcat | grep -i autofill
```

## Full Examples

See `README.md` for complete examples of:
- Personal info forms
- Financial forms (credit cards + banking)
- Job application forms

---

**See full documentation:** [README.md](./README.md)
