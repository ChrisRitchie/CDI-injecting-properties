package com.ritchie.chris.properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PropertyResolverTest {

    @Inject
    MySimpleEJB sut;

    @Deployment
    public static Archive<?> createDeployment() throws IOException {
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class).addPackage(MySimpleEJB.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        return archive;
    }

    @Test
    public void testGetApplicationProperty() {

        String property = sut.getProperty();

        assertNull(property);
        assertEquals("", property);
    }

}
