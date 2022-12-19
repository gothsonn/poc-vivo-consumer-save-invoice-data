package com.accenture.pocvivoconsumersaveinvoicedata.dominio;

import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.EqualsAndHashCodeMatchRule;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.*;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.ProductDto;

@SpringBootTest
class PojoTest {
    private static final String POJO_PACKAGE = "com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos";

    @Test
    public void pojoGetterSetterTest() {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

        validator.validate(POJO_PACKAGE, new FilterPackageInfo());
    }

    @Test
    void hashCodeAndEqualsShouldBehaveProperlyTest() {
        Validator validator = ValidatorBuilder.create().with(new EqualsAndHashCodeMatchRule()).build();
        validator.validate(POJO_PACKAGE, new FilterPackageInfo());

        EqualsVerifier.simple().forPackage(POJO_PACKAGE)
                .except(ProductDto.class)
                .verify();
    }
}
