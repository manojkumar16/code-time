package etc.xml;
import java.util.ArrayList;
import java.util.List;

public class ProvisioningProperties {

    protected ProvisioningProperties.Namespaces namespaces;

    protected ProvisioningProperties.Properties properties;

    public ProvisioningProperties.Namespaces getNamespaces() {
        return namespaces;
    }

    public void setNamespaces( ProvisioningProperties.Namespaces value ) {
        this.namespaces = value;
    }

    public ProvisioningProperties.Properties getProperties() {
        return properties;
    }

    public void setProperties( ProvisioningProperties.Properties value ) {
        this.properties = value;
    }

    public static class Namespaces {

        protected List<ProvisioningProperties.Namespaces.Namespace> namespace;

        public List<ProvisioningProperties.Namespaces.Namespace> getNamespace() {
            if ( namespace == null ) {
                namespace = new ArrayList<ProvisioningProperties.Namespaces.Namespace>();
            }
            return this.namespace;
        }

        public static class Namespace {

            protected String ns;

            protected String uri;

            public String getNs() {
                return ns;
            }

            public void setNs( String value ) {
                this.ns = value;
            }

            public String getUri() {
                return uri;
            }

            public void setUri( String value ) {
                this.uri = value;
            }

        }

    }

    public static class Properties {

        protected List<ProvisioningProperties.Properties.Property> property;

        public List<ProvisioningProperties.Properties.Property> getProperty() {
            if ( property == null ) {
                property = new ArrayList<ProvisioningProperties.Properties.Property>();
            }
            return this.property;
        }

        public static class Property {

            protected String key;

            protected String value;

            public String getKey() {
                return key;
            }

            public void setKey( String value ) {
                this.key = value;
            }

            public String getValue() {
                return value;
            }

            public void setValue( String value ) {
                this.value = value;
            }
        }
    }
}
