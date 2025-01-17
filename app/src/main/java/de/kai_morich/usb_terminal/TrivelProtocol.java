package de.kai_morich.usb_terminal;

public final class TrivelProtocol {
  private TrivelProtocol() {}
  public static void registerAllExtensions(
          com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
          com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
            (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface OscillatorSettingsOrBuilder extends
          // @@protoc_insertion_point(interface_extends:OscillatorSettings)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>double gain = 1;</code>
     * @return The gain.
     */
    double getGain();

    /**
     * <code>double period = 2;</code>
     * @return The period.
     */
    double getPeriod();

    /**
     * <code>double phase = 3;</code>
     * @return The phase.
     */
    double getPhase();
  }
  /**
   * Protobuf type {@code OscillatorSettings}
   */
  public static final class OscillatorSettings extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:OscillatorSettings)
          OscillatorSettingsOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use OscillatorSettings.newBuilder() to construct.
    private OscillatorSettings(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private OscillatorSettings() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new OscillatorSettings();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private OscillatorSettings(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 9: {

              gain_ = input.readDouble();
              break;
            }
            case 17: {

              period_ = input.readDouble();
              break;
            }
            case 25: {

              phase_ = input.readDouble();
              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_OscillatorSettings_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_OscillatorSettings_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.class, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder.class);
    }

    public static final int GAIN_FIELD_NUMBER = 1;
    private double gain_;
    /**
     * <code>double gain = 1;</code>
     * @return The gain.
     */
    @java.lang.Override
    public double getGain() {
      return gain_;
    }

    public static final int PERIOD_FIELD_NUMBER = 2;
    private double period_;
    /**
     * <code>double period = 2;</code>
     * @return The period.
     */
    @java.lang.Override
    public double getPeriod() {
      return period_;
    }

    public static final int PHASE_FIELD_NUMBER = 3;
    private double phase_;
    /**
     * <code>double phase = 3;</code>
     * @return The phase.
     */
    @java.lang.Override
    public double getPhase() {
      return phase_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (java.lang.Double.doubleToRawLongBits(gain_) != 0) {
        output.writeDouble(1, gain_);
      }
      if (java.lang.Double.doubleToRawLongBits(period_) != 0) {
        output.writeDouble(2, period_);
      }
      if (java.lang.Double.doubleToRawLongBits(phase_) != 0) {
        output.writeDouble(3, phase_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (java.lang.Double.doubleToRawLongBits(gain_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(1, gain_);
      }
      if (java.lang.Double.doubleToRawLongBits(period_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(2, period_);
      }
      if (java.lang.Double.doubleToRawLongBits(phase_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(3, phase_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings other = (de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings) obj;

      if (java.lang.Double.doubleToLongBits(getGain())
              != java.lang.Double.doubleToLongBits(
              other.getGain())) return false;
      if (java.lang.Double.doubleToLongBits(getPeriod())
              != java.lang.Double.doubleToLongBits(
              other.getPeriod())) return false;
      if (java.lang.Double.doubleToLongBits(getPhase())
              != java.lang.Double.doubleToLongBits(
              other.getPhase())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + GAIN_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getGain()));
      hash = (37 * hash) + PERIOD_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getPeriod()));
      hash = (37 * hash) + PHASE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getPhase()));
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code OscillatorSettings}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:OscillatorSettings)
            de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_OscillatorSettings_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_OscillatorSettings_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.class, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        gain_ = 0D;

        period_ = 0D;

        phase_ = 0D;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_OscillatorSettings_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings build() {
        de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings result = new de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings(this);
        result.gain_ = gain_;
        result.period_ = period_;
        result.phase_ = phase_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.getDefaultInstance()) return this;
        if (other.getGain() != 0D) {
          setGain(other.getGain());
        }
        if (other.getPeriod() != 0D) {
          setPeriod(other.getPeriod());
        }
        if (other.getPhase() != 0D) {
          setPhase(other.getPhase());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private double gain_ ;
      /**
       * <code>double gain = 1;</code>
       * @return The gain.
       */
      @java.lang.Override
      public double getGain() {
        return gain_;
      }
      /**
       * <code>double gain = 1;</code>
       * @param value The gain to set.
       * @return This builder for chaining.
       */
      public Builder setGain(double value) {

        gain_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double gain = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearGain() {

        gain_ = 0D;
        onChanged();
        return this;
      }

      private double period_ ;
      /**
       * <code>double period = 2;</code>
       * @return The period.
       */
      @java.lang.Override
      public double getPeriod() {
        return period_;
      }
      /**
       * <code>double period = 2;</code>
       * @param value The period to set.
       * @return This builder for chaining.
       */
      public Builder setPeriod(double value) {

        period_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double period = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearPeriod() {

        period_ = 0D;
        onChanged();
        return this;
      }

      private double phase_ ;
      /**
       * <code>double phase = 3;</code>
       * @return The phase.
       */
      @java.lang.Override
      public double getPhase() {
        return phase_;
      }
      /**
       * <code>double phase = 3;</code>
       * @param value The phase to set.
       * @return This builder for chaining.
       */
      public Builder setPhase(double value) {

        phase_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double phase = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearPhase() {

        phase_ = 0D;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:OscillatorSettings)
    }

    // @@protoc_insertion_point(class_scope:OscillatorSettings)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<OscillatorSettings>
            PARSER = new com.google.protobuf.AbstractParser<OscillatorSettings>() {
      @java.lang.Override
      public OscillatorSettings parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new OscillatorSettings(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<OscillatorSettings> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<OscillatorSettings> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface AssistanceSettingsOrBuilder extends
          // @@protoc_insertion_point(interface_extends:AssistanceSettings)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>double cadence = 1;</code>
     * @return The cadence.
     */
    double getCadence();

    /**
     * <code>bool timeSettingsEnable = 2;</code>
     * @return The timeSettingsEnable.
     */
    boolean getTimeSettingsEnable();
  }
  /**
   * Protobuf type {@code AssistanceSettings}
   */
  public static final class AssistanceSettings extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:AssistanceSettings)
          AssistanceSettingsOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use AssistanceSettings.newBuilder() to construct.
    private AssistanceSettings(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AssistanceSettings() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new AssistanceSettings();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AssistanceSettings(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 9: {

              cadence_ = input.readDouble();
              break;
            }
            case 16: {

              timeSettingsEnable_ = input.readBool();
              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_AssistanceSettings_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_AssistanceSettings_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.class, de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.Builder.class);
    }

    public static final int CADENCE_FIELD_NUMBER = 1;
    private double cadence_;
    /**
     * <code>double cadence = 1;</code>
     * @return The cadence.
     */
    @java.lang.Override
    public double getCadence() {
      return cadence_;
    }

    public static final int TIMESETTINGSENABLE_FIELD_NUMBER = 2;
    private boolean timeSettingsEnable_;
    /**
     * <code>bool timeSettingsEnable = 2;</code>
     * @return The timeSettingsEnable.
     */
    @java.lang.Override
    public boolean getTimeSettingsEnable() {
      return timeSettingsEnable_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (java.lang.Double.doubleToRawLongBits(cadence_) != 0) {
        output.writeDouble(1, cadence_);
      }
      if (timeSettingsEnable_ != false) {
        output.writeBool(2, timeSettingsEnable_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (java.lang.Double.doubleToRawLongBits(cadence_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(1, cadence_);
      }
      if (timeSettingsEnable_ != false) {
        size += com.google.protobuf.CodedOutputStream
                .computeBoolSize(2, timeSettingsEnable_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings other = (de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings) obj;

      if (java.lang.Double.doubleToLongBits(getCadence())
              != java.lang.Double.doubleToLongBits(
              other.getCadence())) return false;
      if (getTimeSettingsEnable()
              != other.getTimeSettingsEnable()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + CADENCE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getCadence()));
      hash = (37 * hash) + TIMESETTINGSENABLE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
              getTimeSettingsEnable());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code AssistanceSettings}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:AssistanceSettings)
            de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettingsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_AssistanceSettings_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_AssistanceSettings_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.class, de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        cadence_ = 0D;

        timeSettingsEnable_ = false;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_AssistanceSettings_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings build() {
        de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings result = new de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings(this);
        result.cadence_ = cadence_;
        result.timeSettingsEnable_ = timeSettingsEnable_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.getDefaultInstance()) return this;
        if (other.getCadence() != 0D) {
          setCadence(other.getCadence());
        }
        if (other.getTimeSettingsEnable() != false) {
          setTimeSettingsEnable(other.getTimeSettingsEnable());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private double cadence_ ;
      /**
       * <code>double cadence = 1;</code>
       * @return The cadence.
       */
      @java.lang.Override
      public double getCadence() {
        return cadence_;
      }
      /**
       * <code>double cadence = 1;</code>
       * @param value The cadence to set.
       * @return This builder for chaining.
       */
      public Builder setCadence(double value) {

        cadence_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double cadence = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearCadence() {

        cadence_ = 0D;
        onChanged();
        return this;
      }

      private boolean timeSettingsEnable_ ;
      /**
       * <code>bool timeSettingsEnable = 2;</code>
       * @return The timeSettingsEnable.
       */
      @java.lang.Override
      public boolean getTimeSettingsEnable() {
        return timeSettingsEnable_;
      }
      /**
       * <code>bool timeSettingsEnable = 2;</code>
       * @param value The timeSettingsEnable to set.
       * @return This builder for chaining.
       */
      public Builder setTimeSettingsEnable(boolean value) {

        timeSettingsEnable_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool timeSettingsEnable = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearTimeSettingsEnable() {

        timeSettingsEnable_ = false;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:AssistanceSettings)
    }

    // @@protoc_insertion_point(class_scope:AssistanceSettings)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AssistanceSettings>
            PARSER = new com.google.protobuf.AbstractParser<AssistanceSettings>() {
      @java.lang.Override
      public AssistanceSettings parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new AssistanceSettings(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AssistanceSettings> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AssistanceSettings> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface ResistanceSettingsOrBuilder extends
          // @@protoc_insertion_point(interface_extends:ResistanceSettings)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>double damping = 1;</code>
     * @return The damping.
     */
    double getDamping();

    /**
     * <code>double inertia = 2;</code>
     * @return The inertia.
     */
    double getInertia();

    /**
     * <code>double torque = 3;</code>
     * @return The torque.
     */
    double getTorque();

    /**
     * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
     * @return Whether the positionOscillatorSettings field is set.
     */
    boolean hasPositionOscillatorSettings();
    /**
     * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
     * @return The positionOscillatorSettings.
     */
    de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings getPositionOscillatorSettings();
    /**
     * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder getPositionOscillatorSettingsOrBuilder();

    /**
     * <code>bool PostionSettingsEnable = 5;</code>
     * @return The postionSettingsEnable.
     */
    boolean getPostionSettingsEnable();
  }
  /**
   * Protobuf type {@code ResistanceSettings}
   */
  public static final class ResistanceSettings extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:ResistanceSettings)
          ResistanceSettingsOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use ResistanceSettings.newBuilder() to construct.
    private ResistanceSettings(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ResistanceSettings() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new ResistanceSettings();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ResistanceSettings(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 9: {

              damping_ = input.readDouble();
              break;
            }
            case 17: {

              inertia_ = input.readDouble();
              break;
            }
            case 25: {

              torque_ = input.readDouble();
              break;
            }
            case 34: {
              de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder subBuilder = null;
              if (positionOscillatorSettings_ != null) {
                subBuilder = positionOscillatorSettings_.toBuilder();
              }
              positionOscillatorSettings_ = input.readMessage(de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(positionOscillatorSettings_);
                positionOscillatorSettings_ = subBuilder.buildPartial();
              }

              break;
            }
            case 40: {

              postionSettingsEnable_ = input.readBool();
              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_ResistanceSettings_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_ResistanceSettings_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.class, de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.Builder.class);
    }

    public static final int DAMPING_FIELD_NUMBER = 1;
    private double damping_;
    /**
     * <code>double damping = 1;</code>
     * @return The damping.
     */
    @java.lang.Override
    public double getDamping() {
      return damping_;
    }

    public static final int INERTIA_FIELD_NUMBER = 2;
    private double inertia_;
    /**
     * <code>double inertia = 2;</code>
     * @return The inertia.
     */
    @java.lang.Override
    public double getInertia() {
      return inertia_;
    }

    public static final int TORQUE_FIELD_NUMBER = 3;
    private double torque_;
    /**
     * <code>double torque = 3;</code>
     * @return The torque.
     */
    @java.lang.Override
    public double getTorque() {
      return torque_;
    }

    public static final int POSITIONOSCILLATORSETTINGS_FIELD_NUMBER = 4;
    private de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings positionOscillatorSettings_;
    /**
     * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
     * @return Whether the positionOscillatorSettings field is set.
     */
    @java.lang.Override
    public boolean hasPositionOscillatorSettings() {
      return positionOscillatorSettings_ != null;
    }
    /**
     * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
     * @return The positionOscillatorSettings.
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings getPositionOscillatorSettings() {
      return positionOscillatorSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.getDefaultInstance() : positionOscillatorSettings_;
    }
    /**
     * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder getPositionOscillatorSettingsOrBuilder() {
      return getPositionOscillatorSettings();
    }

    public static final int POSTIONSETTINGSENABLE_FIELD_NUMBER = 5;
    private boolean postionSettingsEnable_;
    /**
     * <code>bool PostionSettingsEnable = 5;</code>
     * @return The postionSettingsEnable.
     */
    @java.lang.Override
    public boolean getPostionSettingsEnable() {
      return postionSettingsEnable_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (java.lang.Double.doubleToRawLongBits(damping_) != 0) {
        output.writeDouble(1, damping_);
      }
      if (java.lang.Double.doubleToRawLongBits(inertia_) != 0) {
        output.writeDouble(2, inertia_);
      }
      if (java.lang.Double.doubleToRawLongBits(torque_) != 0) {
        output.writeDouble(3, torque_);
      }
      if (positionOscillatorSettings_ != null) {
        output.writeMessage(4, getPositionOscillatorSettings());
      }
      if (postionSettingsEnable_ != false) {
        output.writeBool(5, postionSettingsEnable_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (java.lang.Double.doubleToRawLongBits(damping_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(1, damping_);
      }
      if (java.lang.Double.doubleToRawLongBits(inertia_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(2, inertia_);
      }
      if (java.lang.Double.doubleToRawLongBits(torque_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(3, torque_);
      }
      if (positionOscillatorSettings_ != null) {
        size += com.google.protobuf.CodedOutputStream
                .computeMessageSize(4, getPositionOscillatorSettings());
      }
      if (postionSettingsEnable_ != false) {
        size += com.google.protobuf.CodedOutputStream
                .computeBoolSize(5, postionSettingsEnable_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings other = (de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings) obj;

      if (java.lang.Double.doubleToLongBits(getDamping())
              != java.lang.Double.doubleToLongBits(
              other.getDamping())) return false;
      if (java.lang.Double.doubleToLongBits(getInertia())
              != java.lang.Double.doubleToLongBits(
              other.getInertia())) return false;
      if (java.lang.Double.doubleToLongBits(getTorque())
              != java.lang.Double.doubleToLongBits(
              other.getTorque())) return false;
      if (hasPositionOscillatorSettings() != other.hasPositionOscillatorSettings()) return false;
      if (hasPositionOscillatorSettings()) {
        if (!getPositionOscillatorSettings()
                .equals(other.getPositionOscillatorSettings())) return false;
      }
      if (getPostionSettingsEnable()
              != other.getPostionSettingsEnable()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + DAMPING_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getDamping()));
      hash = (37 * hash) + INERTIA_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getInertia()));
      hash = (37 * hash) + TORQUE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getTorque()));
      if (hasPositionOscillatorSettings()) {
        hash = (37 * hash) + POSITIONOSCILLATORSETTINGS_FIELD_NUMBER;
        hash = (53 * hash) + getPositionOscillatorSettings().hashCode();
      }
      hash = (37 * hash) + POSTIONSETTINGSENABLE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
              getPostionSettingsEnable());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code ResistanceSettings}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:ResistanceSettings)
            de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettingsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_ResistanceSettings_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_ResistanceSettings_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.class, de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        damping_ = 0D;

        inertia_ = 0D;

        torque_ = 0D;

        if (positionOscillatorSettingsBuilder_ == null) {
          positionOscillatorSettings_ = null;
        } else {
          positionOscillatorSettings_ = null;
          positionOscillatorSettingsBuilder_ = null;
        }
        postionSettingsEnable_ = false;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_ResistanceSettings_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings build() {
        de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings result = new de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings(this);
        result.damping_ = damping_;
        result.inertia_ = inertia_;
        result.torque_ = torque_;
        if (positionOscillatorSettingsBuilder_ == null) {
          result.positionOscillatorSettings_ = positionOscillatorSettings_;
        } else {
          result.positionOscillatorSettings_ = positionOscillatorSettingsBuilder_.build();
        }
        result.postionSettingsEnable_ = postionSettingsEnable_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.getDefaultInstance()) return this;
        if (other.getDamping() != 0D) {
          setDamping(other.getDamping());
        }
        if (other.getInertia() != 0D) {
          setInertia(other.getInertia());
        }
        if (other.getTorque() != 0D) {
          setTorque(other.getTorque());
        }
        if (other.hasPositionOscillatorSettings()) {
          mergePositionOscillatorSettings(other.getPositionOscillatorSettings());
        }
        if (other.getPostionSettingsEnable() != false) {
          setPostionSettingsEnable(other.getPostionSettingsEnable());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private double damping_ ;
      /**
       * <code>double damping = 1;</code>
       * @return The damping.
       */
      @java.lang.Override
      public double getDamping() {
        return damping_;
      }
      /**
       * <code>double damping = 1;</code>
       * @param value The damping to set.
       * @return This builder for chaining.
       */
      public Builder setDamping(double value) {

        damping_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double damping = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearDamping() {

        damping_ = 0D;
        onChanged();
        return this;
      }

      private double inertia_ ;
      /**
       * <code>double inertia = 2;</code>
       * @return The inertia.
       */
      @java.lang.Override
      public double getInertia() {
        return inertia_;
      }
      /**
       * <code>double inertia = 2;</code>
       * @param value The inertia to set.
       * @return This builder for chaining.
       */
      public Builder setInertia(double value) {

        inertia_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double inertia = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearInertia() {

        inertia_ = 0D;
        onChanged();
        return this;
      }

      private double torque_ ;
      /**
       * <code>double torque = 3;</code>
       * @return The torque.
       */
      @java.lang.Override
      public double getTorque() {
        return torque_;
      }
      /**
       * <code>double torque = 3;</code>
       * @param value The torque to set.
       * @return This builder for chaining.
       */
      public Builder setTorque(double value) {

        torque_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double torque = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearTorque() {

        torque_ = 0D;
        onChanged();
        return this;
      }

      private de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings positionOscillatorSettings_;
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder> positionOscillatorSettingsBuilder_;
      /**
       * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
       * @return Whether the positionOscillatorSettings field is set.
       */
      public boolean hasPositionOscillatorSettings() {
        return positionOscillatorSettingsBuilder_ != null || positionOscillatorSettings_ != null;
      }
      /**
       * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
       * @return The positionOscillatorSettings.
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings getPositionOscillatorSettings() {
        if (positionOscillatorSettingsBuilder_ == null) {
          return positionOscillatorSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.getDefaultInstance() : positionOscillatorSettings_;
        } else {
          return positionOscillatorSettingsBuilder_.getMessage();
        }
      }
      /**
       * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
       */
      public Builder setPositionOscillatorSettings(de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings value) {
        if (positionOscillatorSettingsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          positionOscillatorSettings_ = value;
          onChanged();
        } else {
          positionOscillatorSettingsBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
       */
      public Builder setPositionOscillatorSettings(
              de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder builderForValue) {
        if (positionOscillatorSettingsBuilder_ == null) {
          positionOscillatorSettings_ = builderForValue.build();
          onChanged();
        } else {
          positionOscillatorSettingsBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
       */
      public Builder mergePositionOscillatorSettings(de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings value) {
        if (positionOscillatorSettingsBuilder_ == null) {
          if (positionOscillatorSettings_ != null) {
            positionOscillatorSettings_ =
                    de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.newBuilder(positionOscillatorSettings_).mergeFrom(value).buildPartial();
          } else {
            positionOscillatorSettings_ = value;
          }
          onChanged();
        } else {
          positionOscillatorSettingsBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
       */
      public Builder clearPositionOscillatorSettings() {
        if (positionOscillatorSettingsBuilder_ == null) {
          positionOscillatorSettings_ = null;
          onChanged();
        } else {
          positionOscillatorSettings_ = null;
          positionOscillatorSettingsBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder getPositionOscillatorSettingsBuilder() {

        onChanged();
        return getPositionOscillatorSettingsFieldBuilder().getBuilder();
      }
      /**
       * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder getPositionOscillatorSettingsOrBuilder() {
        if (positionOscillatorSettingsBuilder_ != null) {
          return positionOscillatorSettingsBuilder_.getMessageOrBuilder();
        } else {
          return positionOscillatorSettings_ == null ?
                  de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.getDefaultInstance() : positionOscillatorSettings_;
        }
      }
      /**
       * <code>.OscillatorSettings positionOscillatorSettings = 4;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder>
      getPositionOscillatorSettingsFieldBuilder() {
        if (positionOscillatorSettingsBuilder_ == null) {
          positionOscillatorSettingsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                  de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder>(
                  getPositionOscillatorSettings(),
                  getParentForChildren(),
                  isClean());
          positionOscillatorSettings_ = null;
        }
        return positionOscillatorSettingsBuilder_;
      }

      private boolean postionSettingsEnable_ ;
      /**
       * <code>bool PostionSettingsEnable = 5;</code>
       * @return The postionSettingsEnable.
       */
      @java.lang.Override
      public boolean getPostionSettingsEnable() {
        return postionSettingsEnable_;
      }
      /**
       * <code>bool PostionSettingsEnable = 5;</code>
       * @param value The postionSettingsEnable to set.
       * @return This builder for chaining.
       */
      public Builder setPostionSettingsEnable(boolean value) {

        postionSettingsEnable_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool PostionSettingsEnable = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearPostionSettingsEnable() {

        postionSettingsEnable_ = false;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:ResistanceSettings)
    }

    // @@protoc_insertion_point(class_scope:ResistanceSettings)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ResistanceSettings>
            PARSER = new com.google.protobuf.AbstractParser<ResistanceSettings>() {
      @java.lang.Override
      public ResistanceSettings parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new ResistanceSettings(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ResistanceSettings> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ResistanceSettings> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface RoadfeelSettingsOrBuilder extends
          // @@protoc_insertion_point(interface_extends:RoadfeelSettings)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>double gain = 1;</code>
     * @return The gain.
     */
    double getGain();
  }
  /**
   * Protobuf type {@code RoadfeelSettings}
   */
  public static final class RoadfeelSettings extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:RoadfeelSettings)
          RoadfeelSettingsOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use RoadfeelSettings.newBuilder() to construct.
    private RoadfeelSettings(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RoadfeelSettings() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new RoadfeelSettings();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private RoadfeelSettings(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 9: {

              gain_ = input.readDouble();
              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_RoadfeelSettings_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_RoadfeelSettings_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.class, de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.Builder.class);
    }

    public static final int GAIN_FIELD_NUMBER = 1;
    private double gain_;
    /**
     * <code>double gain = 1;</code>
     * @return The gain.
     */
    @java.lang.Override
    public double getGain() {
      return gain_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (java.lang.Double.doubleToRawLongBits(gain_) != 0) {
        output.writeDouble(1, gain_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (java.lang.Double.doubleToRawLongBits(gain_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(1, gain_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings other = (de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings) obj;

      if (java.lang.Double.doubleToLongBits(getGain())
              != java.lang.Double.doubleToLongBits(
              other.getGain())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + GAIN_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getGain()));
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code RoadfeelSettings}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:RoadfeelSettings)
            de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettingsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_RoadfeelSettings_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_RoadfeelSettings_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.class, de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        gain_ = 0D;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_RoadfeelSettings_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings build() {
        de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings result = new de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings(this);
        result.gain_ = gain_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.getDefaultInstance()) return this;
        if (other.getGain() != 0D) {
          setGain(other.getGain());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private double gain_ ;
      /**
       * <code>double gain = 1;</code>
       * @return The gain.
       */
      @java.lang.Override
      public double getGain() {
        return gain_;
      }
      /**
       * <code>double gain = 1;</code>
       * @param value The gain to set.
       * @return This builder for chaining.
       */
      public Builder setGain(double value) {

        gain_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double gain = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearGain() {

        gain_ = 0D;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:RoadfeelSettings)
    }

    // @@protoc_insertion_point(class_scope:RoadfeelSettings)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RoadfeelSettings>
            PARSER = new com.google.protobuf.AbstractParser<RoadfeelSettings>() {
      @java.lang.Override
      public RoadfeelSettings parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new RoadfeelSettings(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RoadfeelSettings> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RoadfeelSettings> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface CommandOrBuilder extends
          // @@protoc_insertion_point(interface_extends:Command)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.Command.Action action = 1;</code>
     * @return The enum numeric value on the wire for action.
     */
    int getActionValue();
    /**
     * <code>.Command.Action action = 1;</code>
     * @return The action.
     */
    de.kai_morich.usb_terminal.TrivelProtocol.Command.Action getAction();

    /**
     * <code>.AssistanceSettings assistanceSettings = 2;</code>
     * @return Whether the assistanceSettings field is set.
     */
    boolean hasAssistanceSettings();
    /**
     * <code>.AssistanceSettings assistanceSettings = 2;</code>
     * @return The assistanceSettings.
     */
    de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings getAssistanceSettings();
    /**
     * <code>.AssistanceSettings assistanceSettings = 2;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettingsOrBuilder getAssistanceSettingsOrBuilder();

    /**
     * <code>.ResistanceSettings resistanceSettings = 3;</code>
     * @return Whether the resistanceSettings field is set.
     */
    boolean hasResistanceSettings();
    /**
     * <code>.ResistanceSettings resistanceSettings = 3;</code>
     * @return The resistanceSettings.
     */
    de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings getResistanceSettings();
    /**
     * <code>.ResistanceSettings resistanceSettings = 3;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettingsOrBuilder getResistanceSettingsOrBuilder();

    /**
     * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
     * @return Whether the roadfeelSettings field is set.
     */
    boolean hasRoadfeelSettings();
    /**
     * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
     * @return The roadfeelSettings.
     */
    de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings getRoadfeelSettings();
    /**
     * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettingsOrBuilder getRoadfeelSettingsOrBuilder();

    /**
     * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
     * @return Whether the timeOscillatorSettings field is set.
     */
    boolean hasTimeOscillatorSettings();
    /**
     * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
     * @return The timeOscillatorSettings.
     */
    de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings getTimeOscillatorSettings();
    /**
     * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder getTimeOscillatorSettingsOrBuilder();
  }
  /**
   * Protobuf type {@code Command}
   */
  public static final class Command extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:Command)
          CommandOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use Command.newBuilder() to construct.
    private Command(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Command() {
      action_ = 0;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new Command();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Command(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              int rawValue = input.readEnum();

              action_ = rawValue;
              break;
            }
            case 18: {
              de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.Builder subBuilder = null;
              if (assistanceSettings_ != null) {
                subBuilder = assistanceSettings_.toBuilder();
              }
              assistanceSettings_ = input.readMessage(de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(assistanceSettings_);
                assistanceSettings_ = subBuilder.buildPartial();
              }

              break;
            }
            case 26: {
              de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.Builder subBuilder = null;
              if (resistanceSettings_ != null) {
                subBuilder = resistanceSettings_.toBuilder();
              }
              resistanceSettings_ = input.readMessage(de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(resistanceSettings_);
                resistanceSettings_ = subBuilder.buildPartial();
              }

              break;
            }
            case 34: {
              de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.Builder subBuilder = null;
              if (roadfeelSettings_ != null) {
                subBuilder = roadfeelSettings_.toBuilder();
              }
              roadfeelSettings_ = input.readMessage(de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(roadfeelSettings_);
                roadfeelSettings_ = subBuilder.buildPartial();
              }

              break;
            }
            case 42: {
              de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder subBuilder = null;
              if (timeOscillatorSettings_ != null) {
                subBuilder = timeOscillatorSettings_.toBuilder();
              }
              timeOscillatorSettings_ = input.readMessage(de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(timeOscillatorSettings_);
                timeOscillatorSettings_ = subBuilder.buildPartial();
              }

              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Command_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Command_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.Command.class, de.kai_morich.usb_terminal.TrivelProtocol.Command.Builder.class);
    }

    /**
     * Protobuf enum {@code Command.Action}
     */
    public enum Action
            implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>Heartbeat = 0;</code>
       */
      Heartbeat(0),
      /**
       * <code>Idle = 1;</code>
       */
      Idle(1),
      /**
       * <code>GetSignals = 2;</code>
       */
      GetSignals(2),
      /**
       * <code>StartCalibration = 3;</code>
       */
      StartCalibration(3),
      /**
       * <code>SetAssistedMode = 4;</code>
       */
      SetAssistedMode(4),
      /**
       * <code>SetResistanceMode = 5;</code>
       */
      SetResistanceMode(5),
      /**
       * <code>SetRoadfeel = 6;</code>
       */
      SetRoadfeel(6),
      UNRECOGNIZED(-1),
      ;

      /**
       * <code>Heartbeat = 0;</code>
       */
      public static final int Heartbeat_VALUE = 0;
      /**
       * <code>Idle = 1;</code>
       */
      public static final int Idle_VALUE = 1;
      /**
       * <code>GetSignals = 2;</code>
       */
      public static final int GetSignals_VALUE = 2;
      /**
       * <code>StartCalibration = 3;</code>
       */
      public static final int StartCalibration_VALUE = 3;
      /**
       * <code>SetAssistedMode = 4;</code>
       */
      public static final int SetAssistedMode_VALUE = 4;
      /**
       * <code>SetResistanceMode = 5;</code>
       */
      public static final int SetResistanceMode_VALUE = 5;
      /**
       * <code>SetRoadfeel = 6;</code>
       */
      public static final int SetRoadfeel_VALUE = 6;


      public final int getNumber() {
        if (this == UNRECOGNIZED) {
          throw new java.lang.IllegalArgumentException(
                  "Can't get the number of an unknown enum value.");
        }
        return value;
      }

      /**
       * @param value The numeric wire value of the corresponding enum entry.
       * @return The enum associated with the given numeric wire value.
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static Action valueOf(int value) {
        return forNumber(value);
      }

      /**
       * @param value The numeric wire value of the corresponding enum entry.
       * @return The enum associated with the given numeric wire value.
       */
      public static Action forNumber(int value) {
        switch (value) {
          case 0: return Heartbeat;
          case 1: return Idle;
          case 2: return GetSignals;
          case 3: return StartCalibration;
          case 4: return SetAssistedMode;
          case 5: return SetResistanceMode;
          case 6: return SetRoadfeel;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<Action>
      internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
              Action> internalValueMap =
              new com.google.protobuf.Internal.EnumLiteMap<Action>() {
                public Action findValueByNumber(int number) {
                  return Action.forNumber(number);
                }
              };

      public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
        if (this == UNRECOGNIZED) {
          throw new java.lang.IllegalStateException(
                  "Can't get the descriptor of an unrecognized enum value.");
        }
        return getDescriptor().getValues().get(ordinal());
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.Command.getDescriptor().getEnumTypes().get(0);
      }

      private static final Action[] VALUES = values();

      public static Action valueOf(
              com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
                  "EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
          return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
      }

      private final int value;

      private Action(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:Command.Action)
    }

    public static final int ACTION_FIELD_NUMBER = 1;
    private int action_;
    /**
     * <code>.Command.Action action = 1;</code>
     * @return The enum numeric value on the wire for action.
     */
    @java.lang.Override public int getActionValue() {
      return action_;
    }
    /**
     * <code>.Command.Action action = 1;</code>
     * @return The action.
     */
    @java.lang.Override public de.kai_morich.usb_terminal.TrivelProtocol.Command.Action getAction() {
      @SuppressWarnings("deprecation")
      de.kai_morich.usb_terminal.TrivelProtocol.Command.Action result = de.kai_morich.usb_terminal.TrivelProtocol.Command.Action.valueOf(action_);
      return result == null ? de.kai_morich.usb_terminal.TrivelProtocol.Command.Action.UNRECOGNIZED : result;
    }

    public static final int ASSISTANCESETTINGS_FIELD_NUMBER = 2;
    private de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings assistanceSettings_;
    /**
     * <code>.AssistanceSettings assistanceSettings = 2;</code>
     * @return Whether the assistanceSettings field is set.
     */
    @java.lang.Override
    public boolean hasAssistanceSettings() {
      return assistanceSettings_ != null;
    }
    /**
     * <code>.AssistanceSettings assistanceSettings = 2;</code>
     * @return The assistanceSettings.
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings getAssistanceSettings() {
      return assistanceSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.getDefaultInstance() : assistanceSettings_;
    }
    /**
     * <code>.AssistanceSettings assistanceSettings = 2;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettingsOrBuilder getAssistanceSettingsOrBuilder() {
      return getAssistanceSettings();
    }

    public static final int RESISTANCESETTINGS_FIELD_NUMBER = 3;
    private de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings resistanceSettings_;
    /**
     * <code>.ResistanceSettings resistanceSettings = 3;</code>
     * @return Whether the resistanceSettings field is set.
     */
    @java.lang.Override
    public boolean hasResistanceSettings() {
      return resistanceSettings_ != null;
    }
    /**
     * <code>.ResistanceSettings resistanceSettings = 3;</code>
     * @return The resistanceSettings.
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings getResistanceSettings() {
      return resistanceSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.getDefaultInstance() : resistanceSettings_;
    }
    /**
     * <code>.ResistanceSettings resistanceSettings = 3;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettingsOrBuilder getResistanceSettingsOrBuilder() {
      return getResistanceSettings();
    }

    public static final int ROADFEELSETTINGS_FIELD_NUMBER = 4;
    private de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings roadfeelSettings_;
    /**
     * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
     * @return Whether the roadfeelSettings field is set.
     */
    @java.lang.Override
    public boolean hasRoadfeelSettings() {
      return roadfeelSettings_ != null;
    }
    /**
     * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
     * @return The roadfeelSettings.
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings getRoadfeelSettings() {
      return roadfeelSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.getDefaultInstance() : roadfeelSettings_;
    }
    /**
     * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettingsOrBuilder getRoadfeelSettingsOrBuilder() {
      return getRoadfeelSettings();
    }

    public static final int TIMEOSCILLATORSETTINGS_FIELD_NUMBER = 5;
    private de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings timeOscillatorSettings_;
    /**
     * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
     * @return Whether the timeOscillatorSettings field is set.
     */
    @java.lang.Override
    public boolean hasTimeOscillatorSettings() {
      return timeOscillatorSettings_ != null;
    }
    /**
     * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
     * @return The timeOscillatorSettings.
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings getTimeOscillatorSettings() {
      return timeOscillatorSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.getDefaultInstance() : timeOscillatorSettings_;
    }
    /**
     * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder getTimeOscillatorSettingsOrBuilder() {
      return getTimeOscillatorSettings();
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (action_ != de.kai_morich.usb_terminal.TrivelProtocol.Command.Action.Heartbeat.getNumber()) {
        output.writeEnum(1, action_);
      }
      if (assistanceSettings_ != null) {
        output.writeMessage(2, getAssistanceSettings());
      }
      if (resistanceSettings_ != null) {
        output.writeMessage(3, getResistanceSettings());
      }
      if (roadfeelSettings_ != null) {
        output.writeMessage(4, getRoadfeelSettings());
      }
      if (timeOscillatorSettings_ != null) {
        output.writeMessage(5, getTimeOscillatorSettings());
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (action_ != de.kai_morich.usb_terminal.TrivelProtocol.Command.Action.Heartbeat.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
                .computeEnumSize(1, action_);
      }
      if (assistanceSettings_ != null) {
        size += com.google.protobuf.CodedOutputStream
                .computeMessageSize(2, getAssistanceSettings());
      }
      if (resistanceSettings_ != null) {
        size += com.google.protobuf.CodedOutputStream
                .computeMessageSize(3, getResistanceSettings());
      }
      if (roadfeelSettings_ != null) {
        size += com.google.protobuf.CodedOutputStream
                .computeMessageSize(4, getRoadfeelSettings());
      }
      if (timeOscillatorSettings_ != null) {
        size += com.google.protobuf.CodedOutputStream
                .computeMessageSize(5, getTimeOscillatorSettings());
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.Command)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.Command other = (de.kai_morich.usb_terminal.TrivelProtocol.Command) obj;

      if (action_ != other.action_) return false;
      if (hasAssistanceSettings() != other.hasAssistanceSettings()) return false;
      if (hasAssistanceSettings()) {
        if (!getAssistanceSettings()
                .equals(other.getAssistanceSettings())) return false;
      }
      if (hasResistanceSettings() != other.hasResistanceSettings()) return false;
      if (hasResistanceSettings()) {
        if (!getResistanceSettings()
                .equals(other.getResistanceSettings())) return false;
      }
      if (hasRoadfeelSettings() != other.hasRoadfeelSettings()) return false;
      if (hasRoadfeelSettings()) {
        if (!getRoadfeelSettings()
                .equals(other.getRoadfeelSettings())) return false;
      }
      if (hasTimeOscillatorSettings() != other.hasTimeOscillatorSettings()) return false;
      if (hasTimeOscillatorSettings()) {
        if (!getTimeOscillatorSettings()
                .equals(other.getTimeOscillatorSettings())) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ACTION_FIELD_NUMBER;
      hash = (53 * hash) + action_;
      if (hasAssistanceSettings()) {
        hash = (37 * hash) + ASSISTANCESETTINGS_FIELD_NUMBER;
        hash = (53 * hash) + getAssistanceSettings().hashCode();
      }
      if (hasResistanceSettings()) {
        hash = (37 * hash) + RESISTANCESETTINGS_FIELD_NUMBER;
        hash = (53 * hash) + getResistanceSettings().hashCode();
      }
      if (hasRoadfeelSettings()) {
        hash = (37 * hash) + ROADFEELSETTINGS_FIELD_NUMBER;
        hash = (53 * hash) + getRoadfeelSettings().hashCode();
      }
      if (hasTimeOscillatorSettings()) {
        hash = (37 * hash) + TIMEOSCILLATORSETTINGS_FIELD_NUMBER;
        hash = (53 * hash) + getTimeOscillatorSettings().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Command parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.Command prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Command}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:Command)
            de.kai_morich.usb_terminal.TrivelProtocol.CommandOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Command_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Command_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.Command.class, de.kai_morich.usb_terminal.TrivelProtocol.Command.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.Command.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        action_ = 0;

        if (assistanceSettingsBuilder_ == null) {
          assistanceSettings_ = null;
        } else {
          assistanceSettings_ = null;
          assistanceSettingsBuilder_ = null;
        }
        if (resistanceSettingsBuilder_ == null) {
          resistanceSettings_ = null;
        } else {
          resistanceSettings_ = null;
          resistanceSettingsBuilder_ = null;
        }
        if (roadfeelSettingsBuilder_ == null) {
          roadfeelSettings_ = null;
        } else {
          roadfeelSettings_ = null;
          roadfeelSettingsBuilder_ = null;
        }
        if (timeOscillatorSettingsBuilder_ == null) {
          timeOscillatorSettings_ = null;
        } else {
          timeOscillatorSettings_ = null;
          timeOscillatorSettingsBuilder_ = null;
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Command_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.Command getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.Command.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.Command build() {
        de.kai_morich.usb_terminal.TrivelProtocol.Command result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.Command buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.Command result = new de.kai_morich.usb_terminal.TrivelProtocol.Command(this);
        result.action_ = action_;
        if (assistanceSettingsBuilder_ == null) {
          result.assistanceSettings_ = assistanceSettings_;
        } else {
          result.assistanceSettings_ = assistanceSettingsBuilder_.build();
        }
        if (resistanceSettingsBuilder_ == null) {
          result.resistanceSettings_ = resistanceSettings_;
        } else {
          result.resistanceSettings_ = resistanceSettingsBuilder_.build();
        }
        if (roadfeelSettingsBuilder_ == null) {
          result.roadfeelSettings_ = roadfeelSettings_;
        } else {
          result.roadfeelSettings_ = roadfeelSettingsBuilder_.build();
        }
        if (timeOscillatorSettingsBuilder_ == null) {
          result.timeOscillatorSettings_ = timeOscillatorSettings_;
        } else {
          result.timeOscillatorSettings_ = timeOscillatorSettingsBuilder_.build();
        }
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.Command) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.Command)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.Command other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.Command.getDefaultInstance()) return this;
        if (other.action_ != 0) {
          setActionValue(other.getActionValue());
        }
        if (other.hasAssistanceSettings()) {
          mergeAssistanceSettings(other.getAssistanceSettings());
        }
        if (other.hasResistanceSettings()) {
          mergeResistanceSettings(other.getResistanceSettings());
        }
        if (other.hasRoadfeelSettings()) {
          mergeRoadfeelSettings(other.getRoadfeelSettings());
        }
        if (other.hasTimeOscillatorSettings()) {
          mergeTimeOscillatorSettings(other.getTimeOscillatorSettings());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.Command parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.Command) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int action_ = 0;
      /**
       * <code>.Command.Action action = 1;</code>
       * @return The enum numeric value on the wire for action.
       */
      @java.lang.Override public int getActionValue() {
        return action_;
      }
      /**
       * <code>.Command.Action action = 1;</code>
       * @param value The enum numeric value on the wire for action to set.
       * @return This builder for chaining.
       */
      public Builder setActionValue(int value) {

        action_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>.Command.Action action = 1;</code>
       * @return The action.
       */
      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.Command.Action getAction() {
        @SuppressWarnings("deprecation")
        de.kai_morich.usb_terminal.TrivelProtocol.Command.Action result = de.kai_morich.usb_terminal.TrivelProtocol.Command.Action.valueOf(action_);
        return result == null ? de.kai_morich.usb_terminal.TrivelProtocol.Command.Action.UNRECOGNIZED : result;
      }
      /**
       * <code>.Command.Action action = 1;</code>
       * @param value The action to set.
       * @return This builder for chaining.
       */
      public Builder setAction(de.kai_morich.usb_terminal.TrivelProtocol.Command.Action value) {
        if (value == null) {
          throw new NullPointerException();
        }

        action_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>.Command.Action action = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearAction() {

        action_ = 0;
        onChanged();
        return this;
      }

      private de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings assistanceSettings_;
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings, de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettingsOrBuilder> assistanceSettingsBuilder_;
      /**
       * <code>.AssistanceSettings assistanceSettings = 2;</code>
       * @return Whether the assistanceSettings field is set.
       */
      public boolean hasAssistanceSettings() {
        return assistanceSettingsBuilder_ != null || assistanceSettings_ != null;
      }
      /**
       * <code>.AssistanceSettings assistanceSettings = 2;</code>
       * @return The assistanceSettings.
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings getAssistanceSettings() {
        if (assistanceSettingsBuilder_ == null) {
          return assistanceSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.getDefaultInstance() : assistanceSettings_;
        } else {
          return assistanceSettingsBuilder_.getMessage();
        }
      }
      /**
       * <code>.AssistanceSettings assistanceSettings = 2;</code>
       */
      public Builder setAssistanceSettings(de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings value) {
        if (assistanceSettingsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          assistanceSettings_ = value;
          onChanged();
        } else {
          assistanceSettingsBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.AssistanceSettings assistanceSettings = 2;</code>
       */
      public Builder setAssistanceSettings(
              de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.Builder builderForValue) {
        if (assistanceSettingsBuilder_ == null) {
          assistanceSettings_ = builderForValue.build();
          onChanged();
        } else {
          assistanceSettingsBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.AssistanceSettings assistanceSettings = 2;</code>
       */
      public Builder mergeAssistanceSettings(de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings value) {
        if (assistanceSettingsBuilder_ == null) {
          if (assistanceSettings_ != null) {
            assistanceSettings_ =
                    de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.newBuilder(assistanceSettings_).mergeFrom(value).buildPartial();
          } else {
            assistanceSettings_ = value;
          }
          onChanged();
        } else {
          assistanceSettingsBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.AssistanceSettings assistanceSettings = 2;</code>
       */
      public Builder clearAssistanceSettings() {
        if (assistanceSettingsBuilder_ == null) {
          assistanceSettings_ = null;
          onChanged();
        } else {
          assistanceSettings_ = null;
          assistanceSettingsBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.AssistanceSettings assistanceSettings = 2;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.Builder getAssistanceSettingsBuilder() {

        onChanged();
        return getAssistanceSettingsFieldBuilder().getBuilder();
      }
      /**
       * <code>.AssistanceSettings assistanceSettings = 2;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettingsOrBuilder getAssistanceSettingsOrBuilder() {
        if (assistanceSettingsBuilder_ != null) {
          return assistanceSettingsBuilder_.getMessageOrBuilder();
        } else {
          return assistanceSettings_ == null ?
                  de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.getDefaultInstance() : assistanceSettings_;
        }
      }
      /**
       * <code>.AssistanceSettings assistanceSettings = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings, de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettingsOrBuilder>
      getAssistanceSettingsFieldBuilder() {
        if (assistanceSettingsBuilder_ == null) {
          assistanceSettingsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                  de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings, de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.AssistanceSettingsOrBuilder>(
                  getAssistanceSettings(),
                  getParentForChildren(),
                  isClean());
          assistanceSettings_ = null;
        }
        return assistanceSettingsBuilder_;
      }

      private de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings resistanceSettings_;
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings, de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettingsOrBuilder> resistanceSettingsBuilder_;
      /**
       * <code>.ResistanceSettings resistanceSettings = 3;</code>
       * @return Whether the resistanceSettings field is set.
       */
      public boolean hasResistanceSettings() {
        return resistanceSettingsBuilder_ != null || resistanceSettings_ != null;
      }
      /**
       * <code>.ResistanceSettings resistanceSettings = 3;</code>
       * @return The resistanceSettings.
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings getResistanceSettings() {
        if (resistanceSettingsBuilder_ == null) {
          return resistanceSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.getDefaultInstance() : resistanceSettings_;
        } else {
          return resistanceSettingsBuilder_.getMessage();
        }
      }
      /**
       * <code>.ResistanceSettings resistanceSettings = 3;</code>
       */
      public Builder setResistanceSettings(de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings value) {
        if (resistanceSettingsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          resistanceSettings_ = value;
          onChanged();
        } else {
          resistanceSettingsBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.ResistanceSettings resistanceSettings = 3;</code>
       */
      public Builder setResistanceSettings(
              de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.Builder builderForValue) {
        if (resistanceSettingsBuilder_ == null) {
          resistanceSettings_ = builderForValue.build();
          onChanged();
        } else {
          resistanceSettingsBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.ResistanceSettings resistanceSettings = 3;</code>
       */
      public Builder mergeResistanceSettings(de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings value) {
        if (resistanceSettingsBuilder_ == null) {
          if (resistanceSettings_ != null) {
            resistanceSettings_ =
                    de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.newBuilder(resistanceSettings_).mergeFrom(value).buildPartial();
          } else {
            resistanceSettings_ = value;
          }
          onChanged();
        } else {
          resistanceSettingsBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.ResistanceSettings resistanceSettings = 3;</code>
       */
      public Builder clearResistanceSettings() {
        if (resistanceSettingsBuilder_ == null) {
          resistanceSettings_ = null;
          onChanged();
        } else {
          resistanceSettings_ = null;
          resistanceSettingsBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.ResistanceSettings resistanceSettings = 3;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.Builder getResistanceSettingsBuilder() {

        onChanged();
        return getResistanceSettingsFieldBuilder().getBuilder();
      }
      /**
       * <code>.ResistanceSettings resistanceSettings = 3;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettingsOrBuilder getResistanceSettingsOrBuilder() {
        if (resistanceSettingsBuilder_ != null) {
          return resistanceSettingsBuilder_.getMessageOrBuilder();
        } else {
          return resistanceSettings_ == null ?
                  de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.getDefaultInstance() : resistanceSettings_;
        }
      }
      /**
       * <code>.ResistanceSettings resistanceSettings = 3;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings, de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettingsOrBuilder>
      getResistanceSettingsFieldBuilder() {
        if (resistanceSettingsBuilder_ == null) {
          resistanceSettingsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                  de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings, de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.ResistanceSettingsOrBuilder>(
                  getResistanceSettings(),
                  getParentForChildren(),
                  isClean());
          resistanceSettings_ = null;
        }
        return resistanceSettingsBuilder_;
      }

      private de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings roadfeelSettings_;
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings, de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettingsOrBuilder> roadfeelSettingsBuilder_;
      /**
       * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
       * @return Whether the roadfeelSettings field is set.
       */
      public boolean hasRoadfeelSettings() {
        return roadfeelSettingsBuilder_ != null || roadfeelSettings_ != null;
      }
      /**
       * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
       * @return The roadfeelSettings.
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings getRoadfeelSettings() {
        if (roadfeelSettingsBuilder_ == null) {
          return roadfeelSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.getDefaultInstance() : roadfeelSettings_;
        } else {
          return roadfeelSettingsBuilder_.getMessage();
        }
      }
      /**
       * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
       */
      public Builder setRoadfeelSettings(de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings value) {
        if (roadfeelSettingsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          roadfeelSettings_ = value;
          onChanged();
        } else {
          roadfeelSettingsBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
       */
      public Builder setRoadfeelSettings(
              de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.Builder builderForValue) {
        if (roadfeelSettingsBuilder_ == null) {
          roadfeelSettings_ = builderForValue.build();
          onChanged();
        } else {
          roadfeelSettingsBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
       */
      public Builder mergeRoadfeelSettings(de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings value) {
        if (roadfeelSettingsBuilder_ == null) {
          if (roadfeelSettings_ != null) {
            roadfeelSettings_ =
                    de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.newBuilder(roadfeelSettings_).mergeFrom(value).buildPartial();
          } else {
            roadfeelSettings_ = value;
          }
          onChanged();
        } else {
          roadfeelSettingsBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
       */
      public Builder clearRoadfeelSettings() {
        if (roadfeelSettingsBuilder_ == null) {
          roadfeelSettings_ = null;
          onChanged();
        } else {
          roadfeelSettings_ = null;
          roadfeelSettingsBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.Builder getRoadfeelSettingsBuilder() {

        onChanged();
        return getRoadfeelSettingsFieldBuilder().getBuilder();
      }
      /**
       * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettingsOrBuilder getRoadfeelSettingsOrBuilder() {
        if (roadfeelSettingsBuilder_ != null) {
          return roadfeelSettingsBuilder_.getMessageOrBuilder();
        } else {
          return roadfeelSettings_ == null ?
                  de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.getDefaultInstance() : roadfeelSettings_;
        }
      }
      /**
       * <code>.RoadfeelSettings roadfeelSettings = 4;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings, de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettingsOrBuilder>
      getRoadfeelSettingsFieldBuilder() {
        if (roadfeelSettingsBuilder_ == null) {
          roadfeelSettingsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                  de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings, de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.RoadfeelSettingsOrBuilder>(
                  getRoadfeelSettings(),
                  getParentForChildren(),
                  isClean());
          roadfeelSettings_ = null;
        }
        return roadfeelSettingsBuilder_;
      }

      private de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings timeOscillatorSettings_;
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder> timeOscillatorSettingsBuilder_;
      /**
       * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
       * @return Whether the timeOscillatorSettings field is set.
       */
      public boolean hasTimeOscillatorSettings() {
        return timeOscillatorSettingsBuilder_ != null || timeOscillatorSettings_ != null;
      }
      /**
       * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
       * @return The timeOscillatorSettings.
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings getTimeOscillatorSettings() {
        if (timeOscillatorSettingsBuilder_ == null) {
          return timeOscillatorSettings_ == null ? de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.getDefaultInstance() : timeOscillatorSettings_;
        } else {
          return timeOscillatorSettingsBuilder_.getMessage();
        }
      }
      /**
       * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
       */
      public Builder setTimeOscillatorSettings(de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings value) {
        if (timeOscillatorSettingsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          timeOscillatorSettings_ = value;
          onChanged();
        } else {
          timeOscillatorSettingsBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
       */
      public Builder setTimeOscillatorSettings(
              de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder builderForValue) {
        if (timeOscillatorSettingsBuilder_ == null) {
          timeOscillatorSettings_ = builderForValue.build();
          onChanged();
        } else {
          timeOscillatorSettingsBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
       */
      public Builder mergeTimeOscillatorSettings(de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings value) {
        if (timeOscillatorSettingsBuilder_ == null) {
          if (timeOscillatorSettings_ != null) {
            timeOscillatorSettings_ =
                    de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.newBuilder(timeOscillatorSettings_).mergeFrom(value).buildPartial();
          } else {
            timeOscillatorSettings_ = value;
          }
          onChanged();
        } else {
          timeOscillatorSettingsBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
       */
      public Builder clearTimeOscillatorSettings() {
        if (timeOscillatorSettingsBuilder_ == null) {
          timeOscillatorSettings_ = null;
          onChanged();
        } else {
          timeOscillatorSettings_ = null;
          timeOscillatorSettingsBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder getTimeOscillatorSettingsBuilder() {

        onChanged();
        return getTimeOscillatorSettingsFieldBuilder().getBuilder();
      }
      /**
       * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder getTimeOscillatorSettingsOrBuilder() {
        if (timeOscillatorSettingsBuilder_ != null) {
          return timeOscillatorSettingsBuilder_.getMessageOrBuilder();
        } else {
          return timeOscillatorSettings_ == null ?
                  de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.getDefaultInstance() : timeOscillatorSettings_;
        }
      }
      /**
       * <code>.OscillatorSettings timeOscillatorSettings = 5;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder>
      getTimeOscillatorSettingsFieldBuilder() {
        if (timeOscillatorSettingsBuilder_ == null) {
          timeOscillatorSettingsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                  de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettings.Builder, de.kai_morich.usb_terminal.TrivelProtocol.OscillatorSettingsOrBuilder>(
                  getTimeOscillatorSettings(),
                  getParentForChildren(),
                  isClean());
          timeOscillatorSettings_ = null;
        }
        return timeOscillatorSettingsBuilder_;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Command)
    }

    // @@protoc_insertion_point(class_scope:Command)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.Command DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.Command();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.Command getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Command>
            PARSER = new com.google.protobuf.AbstractParser<Command>() {
      @java.lang.Override
      public Command parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new Command(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Command> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Command> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.Command getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface UnsignedIntSignalOrBuilder extends
          // @@protoc_insertion_point(interface_extends:UnsignedIntSignal)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string key = 1;</code>
     * @return The key.
     */
    java.lang.String getKey();
    /**
     * <code>string key = 1;</code>
     * @return The bytes for key.
     */
    com.google.protobuf.ByteString
    getKeyBytes();

    /**
     * <code>string units = 2;</code>
     * @return The units.
     */
    java.lang.String getUnits();
    /**
     * <code>string units = 2;</code>
     * @return The bytes for units.
     */
    com.google.protobuf.ByteString
    getUnitsBytes();

    /**
     * <code>uint32 value = 3;</code>
     * @return The value.
     */
    int getValue();
  }
  /**
   * Protobuf type {@code UnsignedIntSignal}
   */
  public static final class UnsignedIntSignal extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:UnsignedIntSignal)
          UnsignedIntSignalOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use UnsignedIntSignal.newBuilder() to construct.
    private UnsignedIntSignal(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private UnsignedIntSignal() {
      key_ = "";
      units_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new UnsignedIntSignal();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private UnsignedIntSignal(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              key_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              units_ = s;
              break;
            }
            case 24: {

              value_ = input.readUInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_UnsignedIntSignal_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_UnsignedIntSignal_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.class, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder.class);
    }

    public static final int KEY_FIELD_NUMBER = 1;
    private volatile java.lang.Object key_;
    /**
     * <code>string key = 1;</code>
     * @return The key.
     */
    @java.lang.Override
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        key_ = s;
        return s;
      }
    }
    /**
     * <code>string key = 1;</code>
     * @return The bytes for key.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int UNITS_FIELD_NUMBER = 2;
    private volatile java.lang.Object units_;
    /**
     * <code>string units = 2;</code>
     * @return The units.
     */
    @java.lang.Override
    public java.lang.String getUnits() {
      java.lang.Object ref = units_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        units_ = s;
        return s;
      }
    }
    /**
     * <code>string units = 2;</code>
     * @return The bytes for units.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getUnitsBytes() {
      java.lang.Object ref = units_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        units_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VALUE_FIELD_NUMBER = 3;
    private int value_;
    /**
     * <code>uint32 value = 3;</code>
     * @return The value.
     */
    @java.lang.Override
    public int getValue() {
      return value_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(key_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, key_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(units_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, units_);
      }
      if (value_ != 0) {
        output.writeUInt32(3, value_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(key_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, key_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(units_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, units_);
      }
      if (value_ != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeUInt32Size(3, value_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal other = (de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal) obj;

      if (!getKey()
              .equals(other.getKey())) return false;
      if (!getUnits()
              .equals(other.getUnits())) return false;
      if (getValue()
              != other.getValue()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + KEY_FIELD_NUMBER;
      hash = (53 * hash) + getKey().hashCode();
      hash = (37 * hash) + UNITS_FIELD_NUMBER;
      hash = (53 * hash) + getUnits().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code UnsignedIntSignal}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:UnsignedIntSignal)
            de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_UnsignedIntSignal_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_UnsignedIntSignal_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.class, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        key_ = "";

        units_ = "";

        value_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_UnsignedIntSignal_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal build() {
        de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal result = new de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal(this);
        result.key_ = key_;
        result.units_ = units_;
        result.value_ = value_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.getDefaultInstance()) return this;
        if (!other.getKey().isEmpty()) {
          key_ = other.key_;
          onChanged();
        }
        if (!other.getUnits().isEmpty()) {
          units_ = other.units_;
          onChanged();
        }
        if (other.getValue() != 0) {
          setValue(other.getValue());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object key_ = "";
      /**
       * <code>string key = 1;</code>
       * @return The key.
       */
      public java.lang.String getKey() {
        java.lang.Object ref = key_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
                  (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          key_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string key = 1;</code>
       * @return The bytes for key.
       */
      public com.google.protobuf.ByteString
      getKeyBytes() {
        java.lang.Object ref = key_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
                  com.google.protobuf.ByteString.copyFromUtf8(
                          (java.lang.String) ref);
          key_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string key = 1;</code>
       * @param value The key to set.
       * @return This builder for chaining.
       */
      public Builder setKey(
              java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        key_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string key = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearKey() {

        key_ = getDefaultInstance().getKey();
        onChanged();
        return this;
      }
      /**
       * <code>string key = 1;</code>
       * @param value The bytes for key to set.
       * @return This builder for chaining.
       */
      public Builder setKeyBytes(
              com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        key_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object units_ = "";
      /**
       * <code>string units = 2;</code>
       * @return The units.
       */
      public java.lang.String getUnits() {
        java.lang.Object ref = units_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
                  (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          units_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string units = 2;</code>
       * @return The bytes for units.
       */
      public com.google.protobuf.ByteString
      getUnitsBytes() {
        java.lang.Object ref = units_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
                  com.google.protobuf.ByteString.copyFromUtf8(
                          (java.lang.String) ref);
          units_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string units = 2;</code>
       * @param value The units to set.
       * @return This builder for chaining.
       */
      public Builder setUnits(
              java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        units_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string units = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearUnits() {

        units_ = getDefaultInstance().getUnits();
        onChanged();
        return this;
      }
      /**
       * <code>string units = 2;</code>
       * @param value The bytes for units to set.
       * @return This builder for chaining.
       */
      public Builder setUnitsBytes(
              com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        units_ = value;
        onChanged();
        return this;
      }

      private int value_ ;
      /**
       * <code>uint32 value = 3;</code>
       * @return The value.
       */
      @java.lang.Override
      public int getValue() {
        return value_;
      }
      /**
       * <code>uint32 value = 3;</code>
       * @param value The value to set.
       * @return This builder for chaining.
       */
      public Builder setValue(int value) {

        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 value = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearValue() {

        value_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:UnsignedIntSignal)
    }

    // @@protoc_insertion_point(class_scope:UnsignedIntSignal)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<UnsignedIntSignal>
            PARSER = new com.google.protobuf.AbstractParser<UnsignedIntSignal>() {
      @java.lang.Override
      public UnsignedIntSignal parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new UnsignedIntSignal(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<UnsignedIntSignal> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<UnsignedIntSignal> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface IntSignalOrBuilder extends
          // @@protoc_insertion_point(interface_extends:IntSignal)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string key = 1;</code>
     * @return The key.
     */
    java.lang.String getKey();
    /**
     * <code>string key = 1;</code>
     * @return The bytes for key.
     */
    com.google.protobuf.ByteString
    getKeyBytes();

    /**
     * <code>string units = 2;</code>
     * @return The units.
     */
    java.lang.String getUnits();
    /**
     * <code>string units = 2;</code>
     * @return The bytes for units.
     */
    com.google.protobuf.ByteString
    getUnitsBytes();

    /**
     * <code>int32 value = 3;</code>
     * @return The value.
     */
    int getValue();
  }
  /**
   * Protobuf type {@code IntSignal}
   */
  public static final class IntSignal extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:IntSignal)
          IntSignalOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use IntSignal.newBuilder() to construct.
    private IntSignal(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private IntSignal() {
      key_ = "";
      units_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new IntSignal();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private IntSignal(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              key_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              units_ = s;
              break;
            }
            case 24: {

              value_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_IntSignal_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_IntSignal_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.class, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder.class);
    }

    public static final int KEY_FIELD_NUMBER = 1;
    private volatile java.lang.Object key_;
    /**
     * <code>string key = 1;</code>
     * @return The key.
     */
    @java.lang.Override
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        key_ = s;
        return s;
      }
    }
    /**
     * <code>string key = 1;</code>
     * @return The bytes for key.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int UNITS_FIELD_NUMBER = 2;
    private volatile java.lang.Object units_;
    /**
     * <code>string units = 2;</code>
     * @return The units.
     */
    @java.lang.Override
    public java.lang.String getUnits() {
      java.lang.Object ref = units_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        units_ = s;
        return s;
      }
    }
    /**
     * <code>string units = 2;</code>
     * @return The bytes for units.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getUnitsBytes() {
      java.lang.Object ref = units_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        units_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VALUE_FIELD_NUMBER = 3;
    private int value_;
    /**
     * <code>int32 value = 3;</code>
     * @return The value.
     */
    @java.lang.Override
    public int getValue() {
      return value_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(key_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, key_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(units_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, units_);
      }
      if (value_ != 0) {
        output.writeInt32(3, value_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(key_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, key_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(units_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, units_);
      }
      if (value_ != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeInt32Size(3, value_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.IntSignal)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.IntSignal other = (de.kai_morich.usb_terminal.TrivelProtocol.IntSignal) obj;

      if (!getKey()
              .equals(other.getKey())) return false;
      if (!getUnits()
              .equals(other.getUnits())) return false;
      if (getValue()
              != other.getValue()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + KEY_FIELD_NUMBER;
      hash = (53 * hash) + getKey().hashCode();
      hash = (37 * hash) + UNITS_FIELD_NUMBER;
      hash = (53 * hash) + getUnits().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.IntSignal prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code IntSignal}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:IntSignal)
            de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_IntSignal_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_IntSignal_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.class, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        key_ = "";

        units_ = "";

        value_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_IntSignal_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.IntSignal getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.IntSignal build() {
        de.kai_morich.usb_terminal.TrivelProtocol.IntSignal result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.IntSignal buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.IntSignal result = new de.kai_morich.usb_terminal.TrivelProtocol.IntSignal(this);
        result.key_ = key_;
        result.units_ = units_;
        result.value_ = value_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.IntSignal) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.IntSignal)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.IntSignal other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.getDefaultInstance()) return this;
        if (!other.getKey().isEmpty()) {
          key_ = other.key_;
          onChanged();
        }
        if (!other.getUnits().isEmpty()) {
          units_ = other.units_;
          onChanged();
        }
        if (other.getValue() != 0) {
          setValue(other.getValue());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.IntSignal parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.IntSignal) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object key_ = "";
      /**
       * <code>string key = 1;</code>
       * @return The key.
       */
      public java.lang.String getKey() {
        java.lang.Object ref = key_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
                  (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          key_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string key = 1;</code>
       * @return The bytes for key.
       */
      public com.google.protobuf.ByteString
      getKeyBytes() {
        java.lang.Object ref = key_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
                  com.google.protobuf.ByteString.copyFromUtf8(
                          (java.lang.String) ref);
          key_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string key = 1;</code>
       * @param value The key to set.
       * @return This builder for chaining.
       */
      public Builder setKey(
              java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        key_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string key = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearKey() {

        key_ = getDefaultInstance().getKey();
        onChanged();
        return this;
      }
      /**
       * <code>string key = 1;</code>
       * @param value The bytes for key to set.
       * @return This builder for chaining.
       */
      public Builder setKeyBytes(
              com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        key_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object units_ = "";
      /**
       * <code>string units = 2;</code>
       * @return The units.
       */
      public java.lang.String getUnits() {
        java.lang.Object ref = units_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
                  (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          units_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string units = 2;</code>
       * @return The bytes for units.
       */
      public com.google.protobuf.ByteString
      getUnitsBytes() {
        java.lang.Object ref = units_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
                  com.google.protobuf.ByteString.copyFromUtf8(
                          (java.lang.String) ref);
          units_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string units = 2;</code>
       * @param value The units to set.
       * @return This builder for chaining.
       */
      public Builder setUnits(
              java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        units_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string units = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearUnits() {

        units_ = getDefaultInstance().getUnits();
        onChanged();
        return this;
      }
      /**
       * <code>string units = 2;</code>
       * @param value The bytes for units to set.
       * @return This builder for chaining.
       */
      public Builder setUnitsBytes(
              com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        units_ = value;
        onChanged();
        return this;
      }

      private int value_ ;
      /**
       * <code>int32 value = 3;</code>
       * @return The value.
       */
      @java.lang.Override
      public int getValue() {
        return value_;
      }
      /**
       * <code>int32 value = 3;</code>
       * @param value The value to set.
       * @return This builder for chaining.
       */
      public Builder setValue(int value) {

        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 value = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearValue() {

        value_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:IntSignal)
    }

    // @@protoc_insertion_point(class_scope:IntSignal)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.IntSignal DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.IntSignal();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.IntSignal getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<IntSignal>
            PARSER = new com.google.protobuf.AbstractParser<IntSignal>() {
      @java.lang.Override
      public IntSignal parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new IntSignal(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<IntSignal> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<IntSignal> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.IntSignal getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface DoubleSignalOrBuilder extends
          // @@protoc_insertion_point(interface_extends:DoubleSignal)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string key = 1;</code>
     * @return The key.
     */
    java.lang.String getKey();
    /**
     * <code>string key = 1;</code>
     * @return The bytes for key.
     */
    com.google.protobuf.ByteString
    getKeyBytes();

    /**
     * <code>string units = 2;</code>
     * @return The units.
     */
    java.lang.String getUnits();
    /**
     * <code>string units = 2;</code>
     * @return The bytes for units.
     */
    com.google.protobuf.ByteString
    getUnitsBytes();

    /**
     * <code>double value = 3;</code>
     * @return The value.
     */
    double getValue();
  }
  /**
   * Protobuf type {@code DoubleSignal}
   */
  public static final class DoubleSignal extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:DoubleSignal)
          DoubleSignalOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use DoubleSignal.newBuilder() to construct.
    private DoubleSignal(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private DoubleSignal() {
      key_ = "";
      units_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new DoubleSignal();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private DoubleSignal(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              key_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              units_ = s;
              break;
            }
            case 25: {

              value_ = input.readDouble();
              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_DoubleSignal_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_DoubleSignal_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.class, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder.class);
    }

    public static final int KEY_FIELD_NUMBER = 1;
    private volatile java.lang.Object key_;
    /**
     * <code>string key = 1;</code>
     * @return The key.
     */
    @java.lang.Override
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        key_ = s;
        return s;
      }
    }
    /**
     * <code>string key = 1;</code>
     * @return The bytes for key.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int UNITS_FIELD_NUMBER = 2;
    private volatile java.lang.Object units_;
    /**
     * <code>string units = 2;</code>
     * @return The units.
     */
    @java.lang.Override
    public java.lang.String getUnits() {
      java.lang.Object ref = units_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        units_ = s;
        return s;
      }
    }
    /**
     * <code>string units = 2;</code>
     * @return The bytes for units.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
    getUnitsBytes() {
      java.lang.Object ref = units_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        units_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VALUE_FIELD_NUMBER = 3;
    private double value_;
    /**
     * <code>double value = 3;</code>
     * @return The value.
     */
    @java.lang.Override
    public double getValue() {
      return value_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(key_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, key_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(units_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, units_);
      }
      if (java.lang.Double.doubleToRawLongBits(value_) != 0) {
        output.writeDouble(3, value_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(key_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, key_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(units_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, units_);
      }
      if (java.lang.Double.doubleToRawLongBits(value_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(3, value_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal other = (de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal) obj;

      if (!getKey()
              .equals(other.getKey())) return false;
      if (!getUnits()
              .equals(other.getUnits())) return false;
      if (java.lang.Double.doubleToLongBits(getValue())
              != java.lang.Double.doubleToLongBits(
              other.getValue())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + KEY_FIELD_NUMBER;
      hash = (53 * hash) + getKey().hashCode();
      hash = (37 * hash) + UNITS_FIELD_NUMBER;
      hash = (53 * hash) + getUnits().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getValue()));
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code DoubleSignal}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:DoubleSignal)
            de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_DoubleSignal_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_DoubleSignal_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.class, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        key_ = "";

        units_ = "";

        value_ = 0D;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_DoubleSignal_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal build() {
        de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal result = new de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal(this);
        result.key_ = key_;
        result.units_ = units_;
        result.value_ = value_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.getDefaultInstance()) return this;
        if (!other.getKey().isEmpty()) {
          key_ = other.key_;
          onChanged();
        }
        if (!other.getUnits().isEmpty()) {
          units_ = other.units_;
          onChanged();
        }
        if (other.getValue() != 0D) {
          setValue(other.getValue());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object key_ = "";
      /**
       * <code>string key = 1;</code>
       * @return The key.
       */
      public java.lang.String getKey() {
        java.lang.Object ref = key_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
                  (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          key_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string key = 1;</code>
       * @return The bytes for key.
       */
      public com.google.protobuf.ByteString
      getKeyBytes() {
        java.lang.Object ref = key_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
                  com.google.protobuf.ByteString.copyFromUtf8(
                          (java.lang.String) ref);
          key_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string key = 1;</code>
       * @param value The key to set.
       * @return This builder for chaining.
       */
      public Builder setKey(
              java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        key_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string key = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearKey() {

        key_ = getDefaultInstance().getKey();
        onChanged();
        return this;
      }
      /**
       * <code>string key = 1;</code>
       * @param value The bytes for key to set.
       * @return This builder for chaining.
       */
      public Builder setKeyBytes(
              com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        key_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object units_ = "";
      /**
       * <code>string units = 2;</code>
       * @return The units.
       */
      public java.lang.String getUnits() {
        java.lang.Object ref = units_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
                  (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          units_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string units = 2;</code>
       * @return The bytes for units.
       */
      public com.google.protobuf.ByteString
      getUnitsBytes() {
        java.lang.Object ref = units_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
                  com.google.protobuf.ByteString.copyFromUtf8(
                          (java.lang.String) ref);
          units_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string units = 2;</code>
       * @param value The units to set.
       * @return This builder for chaining.
       */
      public Builder setUnits(
              java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        units_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string units = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearUnits() {

        units_ = getDefaultInstance().getUnits();
        onChanged();
        return this;
      }
      /**
       * <code>string units = 2;</code>
       * @param value The bytes for units to set.
       * @return This builder for chaining.
       */
      public Builder setUnitsBytes(
              com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        units_ = value;
        onChanged();
        return this;
      }

      private double value_ ;
      /**
       * <code>double value = 3;</code>
       * @return The value.
       */
      @java.lang.Override
      public double getValue() {
        return value_;
      }
      /**
       * <code>double value = 3;</code>
       * @param value The value to set.
       * @return This builder for chaining.
       */
      public Builder setValue(double value) {

        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double value = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearValue() {

        value_ = 0D;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:DoubleSignal)
    }

    // @@protoc_insertion_point(class_scope:DoubleSignal)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<DoubleSignal>
            PARSER = new com.google.protobuf.AbstractParser<DoubleSignal>() {
      @java.lang.Override
      public DoubleSignal parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new DoubleSignal(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<DoubleSignal> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<DoubleSignal> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface ReplyOrBuilder extends
          // @@protoc_insertion_point(interface_extends:Reply)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal>
    getUnsignedIntSignalsList();
    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal getUnsignedIntSignals(int index);
    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    int getUnsignedIntSignalsCount();
    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    java.util.List<? extends de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder>
    getUnsignedIntSignalsOrBuilderList();
    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder getUnsignedIntSignalsOrBuilder(
            int index);

    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.IntSignal>
    getIntSignalsList();
    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.IntSignal getIntSignals(int index);
    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    int getIntSignalsCount();
    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    java.util.List<? extends de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder>
    getIntSignalsOrBuilderList();
    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder getIntSignalsOrBuilder(
            int index);

    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal>
    getDoubleSignalsList();
    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal getDoubleSignals(int index);
    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    int getDoubleSignalsCount();
    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    java.util.List<? extends de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder>
    getDoubleSignalsOrBuilderList();
    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder getDoubleSignalsOrBuilder(
            int index);

    /**
     * <code>double position = 4;</code>
     * @return The position.
     */
    double getPosition();

    /**
     * <code>double cadence = 5;</code>
     * @return The cadence.
     */
    double getCadence();

    /**
     * <code>double torque = 6;</code>
     * @return The torque.
     */
    double getTorque();

    /**
     * <code>double power = 7;</code>
     * @return The power.
     */
    double getPower();
  }
  /**
   * Protobuf type {@code Reply}
   */
  public static final class Reply extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:Reply)
          ReplyOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use Reply.newBuilder() to construct.
    private Reply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Reply() {
      unsignedIntSignals_ = java.util.Collections.emptyList();
      intSignals_ = java.util.Collections.emptyList();
      doubleSignals_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new Reply();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Reply(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                unsignedIntSignals_ = new java.util.ArrayList<de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal>();
                mutable_bitField0_ |= 0x00000001;
              }
              unsignedIntSignals_.add(
                      input.readMessage(de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.parser(), extensionRegistry));
              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                intSignals_ = new java.util.ArrayList<de.kai_morich.usb_terminal.TrivelProtocol.IntSignal>();
                mutable_bitField0_ |= 0x00000002;
              }
              intSignals_.add(
                      input.readMessage(de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.parser(), extensionRegistry));
              break;
            }
            case 26: {
              if (!((mutable_bitField0_ & 0x00000004) != 0)) {
                doubleSignals_ = new java.util.ArrayList<de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal>();
                mutable_bitField0_ |= 0x00000004;
              }
              doubleSignals_.add(
                      input.readMessage(de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.parser(), extensionRegistry));
              break;
            }
            case 33: {

              position_ = input.readDouble();
              break;
            }
            case 41: {

              cadence_ = input.readDouble();
              break;
            }
            case 49: {

              torque_ = input.readDouble();
              break;
            }
            case 57: {

              power_ = input.readDouble();
              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          unsignedIntSignals_ = java.util.Collections.unmodifiableList(unsignedIntSignals_);
        }
        if (((mutable_bitField0_ & 0x00000002) != 0)) {
          intSignals_ = java.util.Collections.unmodifiableList(intSignals_);
        }
        if (((mutable_bitField0_ & 0x00000004) != 0)) {
          doubleSignals_ = java.util.Collections.unmodifiableList(doubleSignals_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Reply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Reply_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.Reply.class, de.kai_morich.usb_terminal.TrivelProtocol.Reply.Builder.class);
    }

    public static final int UNSIGNEDINTSIGNALS_FIELD_NUMBER = 1;
    private java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal> unsignedIntSignals_;
    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    @java.lang.Override
    public java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal> getUnsignedIntSignalsList() {
      return unsignedIntSignals_;
    }
    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    @java.lang.Override
    public java.util.List<? extends de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder>
    getUnsignedIntSignalsOrBuilderList() {
      return unsignedIntSignals_;
    }
    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    @java.lang.Override
    public int getUnsignedIntSignalsCount() {
      return unsignedIntSignals_.size();
    }
    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal getUnsignedIntSignals(int index) {
      return unsignedIntSignals_.get(index);
    }
    /**
     * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder getUnsignedIntSignalsOrBuilder(
            int index) {
      return unsignedIntSignals_.get(index);
    }

    public static final int INTSIGNALS_FIELD_NUMBER = 2;
    private java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.IntSignal> intSignals_;
    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    @java.lang.Override
    public java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.IntSignal> getIntSignalsList() {
      return intSignals_;
    }
    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    @java.lang.Override
    public java.util.List<? extends de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder>
    getIntSignalsOrBuilderList() {
      return intSignals_;
    }
    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    @java.lang.Override
    public int getIntSignalsCount() {
      return intSignals_.size();
    }
    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.IntSignal getIntSignals(int index) {
      return intSignals_.get(index);
    }
    /**
     * <code>repeated .IntSignal intSignals = 2;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder getIntSignalsOrBuilder(
            int index) {
      return intSignals_.get(index);
    }

    public static final int DOUBLESIGNALS_FIELD_NUMBER = 3;
    private java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal> doubleSignals_;
    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    @java.lang.Override
    public java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal> getDoubleSignalsList() {
      return doubleSignals_;
    }
    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    @java.lang.Override
    public java.util.List<? extends de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder>
    getDoubleSignalsOrBuilderList() {
      return doubleSignals_;
    }
    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    @java.lang.Override
    public int getDoubleSignalsCount() {
      return doubleSignals_.size();
    }
    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal getDoubleSignals(int index) {
      return doubleSignals_.get(index);
    }
    /**
     * <code>repeated .DoubleSignal doubleSignals = 3;</code>
     */
    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder getDoubleSignalsOrBuilder(
            int index) {
      return doubleSignals_.get(index);
    }

    public static final int POSITION_FIELD_NUMBER = 4;
    private double position_;
    /**
     * <code>double position = 4;</code>
     * @return The position.
     */
    @java.lang.Override
    public double getPosition() {
      return position_;
    }

    public static final int CADENCE_FIELD_NUMBER = 5;
    private double cadence_;
    /**
     * <code>double cadence = 5;</code>
     * @return The cadence.
     */
    @java.lang.Override
    public double getCadence() {
      return cadence_;
    }

    public static final int TORQUE_FIELD_NUMBER = 6;
    private double torque_;
    /**
     * <code>double torque = 6;</code>
     * @return The torque.
     */
    @java.lang.Override
    public double getTorque() {
      return torque_;
    }

    public static final int POWER_FIELD_NUMBER = 7;
    private double power_;
    /**
     * <code>double power = 7;</code>
     * @return The power.
     */
    @java.lang.Override
    public double getPower() {
      return power_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      for (int i = 0; i < unsignedIntSignals_.size(); i++) {
        output.writeMessage(1, unsignedIntSignals_.get(i));
      }
      for (int i = 0; i < intSignals_.size(); i++) {
        output.writeMessage(2, intSignals_.get(i));
      }
      for (int i = 0; i < doubleSignals_.size(); i++) {
        output.writeMessage(3, doubleSignals_.get(i));
      }
      if (java.lang.Double.doubleToRawLongBits(position_) != 0) {
        output.writeDouble(4, position_);
      }
      if (java.lang.Double.doubleToRawLongBits(cadence_) != 0) {
        output.writeDouble(5, cadence_);
      }
      if (java.lang.Double.doubleToRawLongBits(torque_) != 0) {
        output.writeDouble(6, torque_);
      }
      if (java.lang.Double.doubleToRawLongBits(power_) != 0) {
        output.writeDouble(7, power_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < unsignedIntSignals_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
                .computeMessageSize(1, unsignedIntSignals_.get(i));
      }
      for (int i = 0; i < intSignals_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
                .computeMessageSize(2, intSignals_.get(i));
      }
      for (int i = 0; i < doubleSignals_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
                .computeMessageSize(3, doubleSignals_.get(i));
      }
      if (java.lang.Double.doubleToRawLongBits(position_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(4, position_);
      }
      if (java.lang.Double.doubleToRawLongBits(cadence_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(5, cadence_);
      }
      if (java.lang.Double.doubleToRawLongBits(torque_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(6, torque_);
      }
      if (java.lang.Double.doubleToRawLongBits(power_) != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeDoubleSize(7, power_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.Reply)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.Reply other = (de.kai_morich.usb_terminal.TrivelProtocol.Reply) obj;

      if (!getUnsignedIntSignalsList()
              .equals(other.getUnsignedIntSignalsList())) return false;
      if (!getIntSignalsList()
              .equals(other.getIntSignalsList())) return false;
      if (!getDoubleSignalsList()
              .equals(other.getDoubleSignalsList())) return false;
      if (java.lang.Double.doubleToLongBits(getPosition())
              != java.lang.Double.doubleToLongBits(
              other.getPosition())) return false;
      if (java.lang.Double.doubleToLongBits(getCadence())
              != java.lang.Double.doubleToLongBits(
              other.getCadence())) return false;
      if (java.lang.Double.doubleToLongBits(getTorque())
              != java.lang.Double.doubleToLongBits(
              other.getTorque())) return false;
      if (java.lang.Double.doubleToLongBits(getPower())
              != java.lang.Double.doubleToLongBits(
              other.getPower())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (getUnsignedIntSignalsCount() > 0) {
        hash = (37 * hash) + UNSIGNEDINTSIGNALS_FIELD_NUMBER;
        hash = (53 * hash) + getUnsignedIntSignalsList().hashCode();
      }
      if (getIntSignalsCount() > 0) {
        hash = (37 * hash) + INTSIGNALS_FIELD_NUMBER;
        hash = (53 * hash) + getIntSignalsList().hashCode();
      }
      if (getDoubleSignalsCount() > 0) {
        hash = (37 * hash) + DOUBLESIGNALS_FIELD_NUMBER;
        hash = (53 * hash) + getDoubleSignalsList().hashCode();
      }
      hash = (37 * hash) + POSITION_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getPosition()));
      hash = (37 * hash) + CADENCE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getCadence()));
      hash = (37 * hash) + TORQUE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getTorque()));
      hash = (37 * hash) + POWER_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
              java.lang.Double.doubleToLongBits(getPower()));
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.Reply prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Reply}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:Reply)
            de.kai_morich.usb_terminal.TrivelProtocol.ReplyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Reply_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Reply_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.Reply.class, de.kai_morich.usb_terminal.TrivelProtocol.Reply.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.Reply.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
          getUnsignedIntSignalsFieldBuilder();
          getIntSignalsFieldBuilder();
          getDoubleSignalsFieldBuilder();
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (unsignedIntSignalsBuilder_ == null) {
          unsignedIntSignals_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          unsignedIntSignalsBuilder_.clear();
        }
        if (intSignalsBuilder_ == null) {
          intSignals_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          intSignalsBuilder_.clear();
        }
        if (doubleSignalsBuilder_ == null) {
          doubleSignals_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          doubleSignalsBuilder_.clear();
        }
        position_ = 0D;

        cadence_ = 0D;

        torque_ = 0D;

        power_ = 0D;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_Reply_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.Reply getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.Reply.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.Reply build() {
        de.kai_morich.usb_terminal.TrivelProtocol.Reply result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.Reply buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.Reply result = new de.kai_morich.usb_terminal.TrivelProtocol.Reply(this);
        int from_bitField0_ = bitField0_;
        if (unsignedIntSignalsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            unsignedIntSignals_ = java.util.Collections.unmodifiableList(unsignedIntSignals_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.unsignedIntSignals_ = unsignedIntSignals_;
        } else {
          result.unsignedIntSignals_ = unsignedIntSignalsBuilder_.build();
        }
        if (intSignalsBuilder_ == null) {
          if (((bitField0_ & 0x00000002) != 0)) {
            intSignals_ = java.util.Collections.unmodifiableList(intSignals_);
            bitField0_ = (bitField0_ & ~0x00000002);
          }
          result.intSignals_ = intSignals_;
        } else {
          result.intSignals_ = intSignalsBuilder_.build();
        }
        if (doubleSignalsBuilder_ == null) {
          if (((bitField0_ & 0x00000004) != 0)) {
            doubleSignals_ = java.util.Collections.unmodifiableList(doubleSignals_);
            bitField0_ = (bitField0_ & ~0x00000004);
          }
          result.doubleSignals_ = doubleSignals_;
        } else {
          result.doubleSignals_ = doubleSignalsBuilder_.build();
        }
        result.position_ = position_;
        result.cadence_ = cadence_;
        result.torque_ = torque_;
        result.power_ = power_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.Reply) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.Reply)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.Reply other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.Reply.getDefaultInstance()) return this;
        if (unsignedIntSignalsBuilder_ == null) {
          if (!other.unsignedIntSignals_.isEmpty()) {
            if (unsignedIntSignals_.isEmpty()) {
              unsignedIntSignals_ = other.unsignedIntSignals_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureUnsignedIntSignalsIsMutable();
              unsignedIntSignals_.addAll(other.unsignedIntSignals_);
            }
            onChanged();
          }
        } else {
          if (!other.unsignedIntSignals_.isEmpty()) {
            if (unsignedIntSignalsBuilder_.isEmpty()) {
              unsignedIntSignalsBuilder_.dispose();
              unsignedIntSignalsBuilder_ = null;
              unsignedIntSignals_ = other.unsignedIntSignals_;
              bitField0_ = (bitField0_ & ~0x00000001);
              unsignedIntSignalsBuilder_ =
                      com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                              getUnsignedIntSignalsFieldBuilder() : null;
            } else {
              unsignedIntSignalsBuilder_.addAllMessages(other.unsignedIntSignals_);
            }
          }
        }
        if (intSignalsBuilder_ == null) {
          if (!other.intSignals_.isEmpty()) {
            if (intSignals_.isEmpty()) {
              intSignals_ = other.intSignals_;
              bitField0_ = (bitField0_ & ~0x00000002);
            } else {
              ensureIntSignalsIsMutable();
              intSignals_.addAll(other.intSignals_);
            }
            onChanged();
          }
        } else {
          if (!other.intSignals_.isEmpty()) {
            if (intSignalsBuilder_.isEmpty()) {
              intSignalsBuilder_.dispose();
              intSignalsBuilder_ = null;
              intSignals_ = other.intSignals_;
              bitField0_ = (bitField0_ & ~0x00000002);
              intSignalsBuilder_ =
                      com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                              getIntSignalsFieldBuilder() : null;
            } else {
              intSignalsBuilder_.addAllMessages(other.intSignals_);
            }
          }
        }
        if (doubleSignalsBuilder_ == null) {
          if (!other.doubleSignals_.isEmpty()) {
            if (doubleSignals_.isEmpty()) {
              doubleSignals_ = other.doubleSignals_;
              bitField0_ = (bitField0_ & ~0x00000004);
            } else {
              ensureDoubleSignalsIsMutable();
              doubleSignals_.addAll(other.doubleSignals_);
            }
            onChanged();
          }
        } else {
          if (!other.doubleSignals_.isEmpty()) {
            if (doubleSignalsBuilder_.isEmpty()) {
              doubleSignalsBuilder_.dispose();
              doubleSignalsBuilder_ = null;
              doubleSignals_ = other.doubleSignals_;
              bitField0_ = (bitField0_ & ~0x00000004);
              doubleSignalsBuilder_ =
                      com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                              getDoubleSignalsFieldBuilder() : null;
            } else {
              doubleSignalsBuilder_.addAllMessages(other.doubleSignals_);
            }
          }
        }
        if (other.getPosition() != 0D) {
          setPosition(other.getPosition());
        }
        if (other.getCadence() != 0D) {
          setCadence(other.getCadence());
        }
        if (other.getTorque() != 0D) {
          setTorque(other.getTorque());
        }
        if (other.getPower() != 0D) {
          setPower(other.getPower());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.Reply parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.Reply) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal> unsignedIntSignals_ =
              java.util.Collections.emptyList();
      private void ensureUnsignedIntSignalsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          unsignedIntSignals_ = new java.util.ArrayList<de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal>(unsignedIntSignals_);
          bitField0_ |= 0x00000001;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder> unsignedIntSignalsBuilder_;

      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal> getUnsignedIntSignalsList() {
        if (unsignedIntSignalsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(unsignedIntSignals_);
        } else {
          return unsignedIntSignalsBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public int getUnsignedIntSignalsCount() {
        if (unsignedIntSignalsBuilder_ == null) {
          return unsignedIntSignals_.size();
        } else {
          return unsignedIntSignalsBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal getUnsignedIntSignals(int index) {
        if (unsignedIntSignalsBuilder_ == null) {
          return unsignedIntSignals_.get(index);
        } else {
          return unsignedIntSignalsBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public Builder setUnsignedIntSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal value) {
        if (unsignedIntSignalsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUnsignedIntSignalsIsMutable();
          unsignedIntSignals_.set(index, value);
          onChanged();
        } else {
          unsignedIntSignalsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public Builder setUnsignedIntSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder builderForValue) {
        if (unsignedIntSignalsBuilder_ == null) {
          ensureUnsignedIntSignalsIsMutable();
          unsignedIntSignals_.set(index, builderForValue.build());
          onChanged();
        } else {
          unsignedIntSignalsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public Builder addUnsignedIntSignals(de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal value) {
        if (unsignedIntSignalsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUnsignedIntSignalsIsMutable();
          unsignedIntSignals_.add(value);
          onChanged();
        } else {
          unsignedIntSignalsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public Builder addUnsignedIntSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal value) {
        if (unsignedIntSignalsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureUnsignedIntSignalsIsMutable();
          unsignedIntSignals_.add(index, value);
          onChanged();
        } else {
          unsignedIntSignalsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public Builder addUnsignedIntSignals(
              de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder builderForValue) {
        if (unsignedIntSignalsBuilder_ == null) {
          ensureUnsignedIntSignalsIsMutable();
          unsignedIntSignals_.add(builderForValue.build());
          onChanged();
        } else {
          unsignedIntSignalsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public Builder addUnsignedIntSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder builderForValue) {
        if (unsignedIntSignalsBuilder_ == null) {
          ensureUnsignedIntSignalsIsMutable();
          unsignedIntSignals_.add(index, builderForValue.build());
          onChanged();
        } else {
          unsignedIntSignalsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public Builder addAllUnsignedIntSignals(
              java.lang.Iterable<? extends de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal> values) {
        if (unsignedIntSignalsBuilder_ == null) {
          ensureUnsignedIntSignalsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
                  values, unsignedIntSignals_);
          onChanged();
        } else {
          unsignedIntSignalsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public Builder clearUnsignedIntSignals() {
        if (unsignedIntSignalsBuilder_ == null) {
          unsignedIntSignals_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          unsignedIntSignalsBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public Builder removeUnsignedIntSignals(int index) {
        if (unsignedIntSignalsBuilder_ == null) {
          ensureUnsignedIntSignalsIsMutable();
          unsignedIntSignals_.remove(index);
          onChanged();
        } else {
          unsignedIntSignalsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder getUnsignedIntSignalsBuilder(
              int index) {
        return getUnsignedIntSignalsFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder getUnsignedIntSignalsOrBuilder(
              int index) {
        if (unsignedIntSignalsBuilder_ == null) {
          return unsignedIntSignals_.get(index);  } else {
          return unsignedIntSignalsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public java.util.List<? extends de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder>
      getUnsignedIntSignalsOrBuilderList() {
        if (unsignedIntSignalsBuilder_ != null) {
          return unsignedIntSignalsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(unsignedIntSignals_);
        }
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder addUnsignedIntSignalsBuilder() {
        return getUnsignedIntSignalsFieldBuilder().addBuilder(
                de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.getDefaultInstance());
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder addUnsignedIntSignalsBuilder(
              int index) {
        return getUnsignedIntSignalsFieldBuilder().addBuilder(
                index, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.getDefaultInstance());
      }
      /**
       * <code>repeated .UnsignedIntSignal unsignedIntSignals = 1;</code>
       */
      public java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder>
      getUnsignedIntSignalsBuilderList() {
        return getUnsignedIntSignalsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder>
      getUnsignedIntSignalsFieldBuilder() {
        if (unsignedIntSignalsBuilder_ == null) {
          unsignedIntSignalsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                  de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignal.Builder, de.kai_morich.usb_terminal.TrivelProtocol.UnsignedIntSignalOrBuilder>(
                  unsignedIntSignals_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          unsignedIntSignals_ = null;
        }
        return unsignedIntSignalsBuilder_;
      }

      private java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.IntSignal> intSignals_ =
              java.util.Collections.emptyList();
      private void ensureIntSignalsIsMutable() {
        if (!((bitField0_ & 0x00000002) != 0)) {
          intSignals_ = new java.util.ArrayList<de.kai_morich.usb_terminal.TrivelProtocol.IntSignal>(intSignals_);
          bitField0_ |= 0x00000002;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.IntSignal, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder, de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder> intSignalsBuilder_;

      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.IntSignal> getIntSignalsList() {
        if (intSignalsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(intSignals_);
        } else {
          return intSignalsBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public int getIntSignalsCount() {
        if (intSignalsBuilder_ == null) {
          return intSignals_.size();
        } else {
          return intSignalsBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.IntSignal getIntSignals(int index) {
        if (intSignalsBuilder_ == null) {
          return intSignals_.get(index);
        } else {
          return intSignalsBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public Builder setIntSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal value) {
        if (intSignalsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureIntSignalsIsMutable();
          intSignals_.set(index, value);
          onChanged();
        } else {
          intSignalsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public Builder setIntSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder builderForValue) {
        if (intSignalsBuilder_ == null) {
          ensureIntSignalsIsMutable();
          intSignals_.set(index, builderForValue.build());
          onChanged();
        } else {
          intSignalsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public Builder addIntSignals(de.kai_morich.usb_terminal.TrivelProtocol.IntSignal value) {
        if (intSignalsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureIntSignalsIsMutable();
          intSignals_.add(value);
          onChanged();
        } else {
          intSignalsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public Builder addIntSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal value) {
        if (intSignalsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureIntSignalsIsMutable();
          intSignals_.add(index, value);
          onChanged();
        } else {
          intSignalsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public Builder addIntSignals(
              de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder builderForValue) {
        if (intSignalsBuilder_ == null) {
          ensureIntSignalsIsMutable();
          intSignals_.add(builderForValue.build());
          onChanged();
        } else {
          intSignalsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public Builder addIntSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder builderForValue) {
        if (intSignalsBuilder_ == null) {
          ensureIntSignalsIsMutable();
          intSignals_.add(index, builderForValue.build());
          onChanged();
        } else {
          intSignalsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public Builder addAllIntSignals(
              java.lang.Iterable<? extends de.kai_morich.usb_terminal.TrivelProtocol.IntSignal> values) {
        if (intSignalsBuilder_ == null) {
          ensureIntSignalsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
                  values, intSignals_);
          onChanged();
        } else {
          intSignalsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public Builder clearIntSignals() {
        if (intSignalsBuilder_ == null) {
          intSignals_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
          onChanged();
        } else {
          intSignalsBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public Builder removeIntSignals(int index) {
        if (intSignalsBuilder_ == null) {
          ensureIntSignalsIsMutable();
          intSignals_.remove(index);
          onChanged();
        } else {
          intSignalsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder getIntSignalsBuilder(
              int index) {
        return getIntSignalsFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder getIntSignalsOrBuilder(
              int index) {
        if (intSignalsBuilder_ == null) {
          return intSignals_.get(index);  } else {
          return intSignalsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public java.util.List<? extends de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder>
      getIntSignalsOrBuilderList() {
        if (intSignalsBuilder_ != null) {
          return intSignalsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(intSignals_);
        }
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder addIntSignalsBuilder() {
        return getIntSignalsFieldBuilder().addBuilder(
                de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.getDefaultInstance());
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder addIntSignalsBuilder(
              int index) {
        return getIntSignalsFieldBuilder().addBuilder(
                index, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.getDefaultInstance());
      }
      /**
       * <code>repeated .IntSignal intSignals = 2;</code>
       */
      public java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder>
      getIntSignalsBuilderList() {
        return getIntSignalsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.IntSignal, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder, de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder>
      getIntSignalsFieldBuilder() {
        if (intSignalsBuilder_ == null) {
          intSignalsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                  de.kai_morich.usb_terminal.TrivelProtocol.IntSignal, de.kai_morich.usb_terminal.TrivelProtocol.IntSignal.Builder, de.kai_morich.usb_terminal.TrivelProtocol.IntSignalOrBuilder>(
                  intSignals_,
                  ((bitField0_ & 0x00000002) != 0),
                  getParentForChildren(),
                  isClean());
          intSignals_ = null;
        }
        return intSignalsBuilder_;
      }

      private java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal> doubleSignals_ =
              java.util.Collections.emptyList();
      private void ensureDoubleSignalsIsMutable() {
        if (!((bitField0_ & 0x00000004) != 0)) {
          doubleSignals_ = new java.util.ArrayList<de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal>(doubleSignals_);
          bitField0_ |= 0x00000004;
        }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder> doubleSignalsBuilder_;

      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal> getDoubleSignalsList() {
        if (doubleSignalsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(doubleSignals_);
        } else {
          return doubleSignalsBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public int getDoubleSignalsCount() {
        if (doubleSignalsBuilder_ == null) {
          return doubleSignals_.size();
        } else {
          return doubleSignalsBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal getDoubleSignals(int index) {
        if (doubleSignalsBuilder_ == null) {
          return doubleSignals_.get(index);
        } else {
          return doubleSignalsBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public Builder setDoubleSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal value) {
        if (doubleSignalsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureDoubleSignalsIsMutable();
          doubleSignals_.set(index, value);
          onChanged();
        } else {
          doubleSignalsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public Builder setDoubleSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder builderForValue) {
        if (doubleSignalsBuilder_ == null) {
          ensureDoubleSignalsIsMutable();
          doubleSignals_.set(index, builderForValue.build());
          onChanged();
        } else {
          doubleSignalsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public Builder addDoubleSignals(de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal value) {
        if (doubleSignalsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureDoubleSignalsIsMutable();
          doubleSignals_.add(value);
          onChanged();
        } else {
          doubleSignalsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public Builder addDoubleSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal value) {
        if (doubleSignalsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureDoubleSignalsIsMutable();
          doubleSignals_.add(index, value);
          onChanged();
        } else {
          doubleSignalsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public Builder addDoubleSignals(
              de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder builderForValue) {
        if (doubleSignalsBuilder_ == null) {
          ensureDoubleSignalsIsMutable();
          doubleSignals_.add(builderForValue.build());
          onChanged();
        } else {
          doubleSignalsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public Builder addDoubleSignals(
              int index, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder builderForValue) {
        if (doubleSignalsBuilder_ == null) {
          ensureDoubleSignalsIsMutable();
          doubleSignals_.add(index, builderForValue.build());
          onChanged();
        } else {
          doubleSignalsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public Builder addAllDoubleSignals(
              java.lang.Iterable<? extends de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal> values) {
        if (doubleSignalsBuilder_ == null) {
          ensureDoubleSignalsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
                  values, doubleSignals_);
          onChanged();
        } else {
          doubleSignalsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public Builder clearDoubleSignals() {
        if (doubleSignalsBuilder_ == null) {
          doubleSignals_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000004);
          onChanged();
        } else {
          doubleSignalsBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public Builder removeDoubleSignals(int index) {
        if (doubleSignalsBuilder_ == null) {
          ensureDoubleSignalsIsMutable();
          doubleSignals_.remove(index);
          onChanged();
        } else {
          doubleSignalsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder getDoubleSignalsBuilder(
              int index) {
        return getDoubleSignalsFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder getDoubleSignalsOrBuilder(
              int index) {
        if (doubleSignalsBuilder_ == null) {
          return doubleSignals_.get(index);  } else {
          return doubleSignalsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public java.util.List<? extends de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder>
      getDoubleSignalsOrBuilderList() {
        if (doubleSignalsBuilder_ != null) {
          return doubleSignalsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(doubleSignals_);
        }
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder addDoubleSignalsBuilder() {
        return getDoubleSignalsFieldBuilder().addBuilder(
                de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.getDefaultInstance());
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder addDoubleSignalsBuilder(
              int index) {
        return getDoubleSignalsFieldBuilder().addBuilder(
                index, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.getDefaultInstance());
      }
      /**
       * <code>repeated .DoubleSignal doubleSignals = 3;</code>
       */
      public java.util.List<de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder>
      getDoubleSignalsBuilderList() {
        return getDoubleSignalsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
              de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder>
      getDoubleSignalsFieldBuilder() {
        if (doubleSignalsBuilder_ == null) {
          doubleSignalsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                  de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignal.Builder, de.kai_morich.usb_terminal.TrivelProtocol.DoubleSignalOrBuilder>(
                  doubleSignals_,
                  ((bitField0_ & 0x00000004) != 0),
                  getParentForChildren(),
                  isClean());
          doubleSignals_ = null;
        }
        return doubleSignalsBuilder_;
      }

      private double position_ ;
      /**
       * <code>double position = 4;</code>
       * @return The position.
       */
      @java.lang.Override
      public double getPosition() {
        return position_;
      }
      /**
       * <code>double position = 4;</code>
       * @param value The position to set.
       * @return This builder for chaining.
       */
      public Builder setPosition(double value) {

        position_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double position = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearPosition() {

        position_ = 0D;
        onChanged();
        return this;
      }

      private double cadence_ ;
      /**
       * <code>double cadence = 5;</code>
       * @return The cadence.
       */
      @java.lang.Override
      public double getCadence() {
        return cadence_;
      }
      /**
       * <code>double cadence = 5;</code>
       * @param value The cadence to set.
       * @return This builder for chaining.
       */
      public Builder setCadence(double value) {

        cadence_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double cadence = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearCadence() {

        cadence_ = 0D;
        onChanged();
        return this;
      }

      private double torque_ ;
      /**
       * <code>double torque = 6;</code>
       * @return The torque.
       */
      @java.lang.Override
      public double getTorque() {
        return torque_;
      }
      /**
       * <code>double torque = 6;</code>
       * @param value The torque to set.
       * @return This builder for chaining.
       */
      public Builder setTorque(double value) {

        torque_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double torque = 6;</code>
       * @return This builder for chaining.
       */
      public Builder clearTorque() {

        torque_ = 0D;
        onChanged();
        return this;
      }

      private double power_ ;
      /**
       * <code>double power = 7;</code>
       * @return The power.
       */
      @java.lang.Override
      public double getPower() {
        return power_;
      }
      /**
       * <code>double power = 7;</code>
       * @param value The power to set.
       * @return This builder for chaining.
       */
      public Builder setPower(double value) {

        power_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double power = 7;</code>
       * @return This builder for chaining.
       */
      public Builder clearPower() {

        power_ = 0D;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Reply)
    }

    // @@protoc_insertion_point(class_scope:Reply)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.Reply DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.Reply();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.Reply getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Reply>
            PARSER = new com.google.protobuf.AbstractParser<Reply>() {
      @java.lang.Override
      public Reply parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new Reply(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Reply> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Reply> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.Reply getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface LED_BlinkOrBuilder extends
          // @@protoc_insertion_point(interface_extends:LED_Blink)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint32 Freq = 1;</code>
     * @return The freq.
     */
    int getFreq();
  }
  /**
   * Protobuf type {@code LED_Blink}
   */
  public static final class LED_Blink extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:LED_Blink)
          LED_BlinkOrBuilder {
    private static final long serialVersionUID = 0L;
    // Use LED_Blink.newBuilder() to construct.
    private LED_Blink(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private LED_Blink() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
      return new LED_Blink();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private LED_Blink(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
              com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {

              freq_ = input.readUInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                      input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
                e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_LED_Blink_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_LED_Blink_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink.class, de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink.Builder.class);
    }

    public static final int FREQ_FIELD_NUMBER = 1;
    private int freq_;
    /**
     * <code>uint32 Freq = 1;</code>
     * @return The freq.
     */
    @java.lang.Override
    public int getFreq() {
      return freq_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (freq_ != 0) {
        output.writeUInt32(1, freq_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (freq_ != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeUInt32Size(1, freq_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink)) {
        return super.equals(obj);
      }
      de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink other = (de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink) obj;

      if (getFreq()
              != other.getFreq()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + FREQ_FIELD_NUMBER;
      hash = (53 * hash) + getFreq();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }
    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
              ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code LED_Blink}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:LED_Blink)
            de.kai_morich.usb_terminal.TrivelProtocol.LED_BlinkOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_LED_Blink_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_LED_Blink_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink.class, de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink.Builder.class);
      }

      // Construct using de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        freq_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.internal_static_LED_Blink_descriptor;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink getDefaultInstanceForType() {
        return de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink.getDefaultInstance();
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink build() {
        de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink buildPartial() {
        de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink result = new de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink(this);
        result.freq_ = freq_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink) {
          return mergeFrom((de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink other) {
        if (other == de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink.getDefaultInstance()) return this;
        if (other.getFreq() != 0) {
          setFreq(other.getFreq());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws java.io.IOException {
        de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int freq_ ;
      /**
       * <code>uint32 Freq = 1;</code>
       * @return The freq.
       */
      @java.lang.Override
      public int getFreq() {
        return freq_;
      }
      /**
       * <code>uint32 Freq = 1;</code>
       * @param value The freq to set.
       * @return This builder for chaining.
       */
      public Builder setFreq(int value) {

        freq_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 Freq = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearFreq() {

        freq_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
              final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:LED_Blink)
    }

    // @@protoc_insertion_point(class_scope:LED_Blink)
    private static final de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink();
    }

    public static de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<LED_Blink>
            PARSER = new com.google.protobuf.AbstractParser<LED_Blink>() {
      @java.lang.Override
      public LED_Blink parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new LED_Blink(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<LED_Blink> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<LED_Blink> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public de.kai_morich.usb_terminal.TrivelProtocol.LED_Blink getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_OscillatorSettings_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_OscillatorSettings_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_AssistanceSettings_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_AssistanceSettings_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_ResistanceSettings_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_ResistanceSettings_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_RoadfeelSettings_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_RoadfeelSettings_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_Command_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_Command_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_UnsignedIntSignal_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_UnsignedIntSignal_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_IntSignal_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_IntSignal_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_DoubleSignal_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_DoubleSignal_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_Reply_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_Reply_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_LED_Blink_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_LED_Blink_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
  getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
          descriptor;
  static {
    java.lang.String[] descriptorData = {
            "\n\024TrivelProtocol.proto\"A\n\022OscillatorSett" +
                    "ings\022\014\n\004gain\030\001 \001(\001\022\016\n\006period\030\002 \001(\001\022\r\n\005ph" +
                    "ase\030\003 \001(\001\"A\n\022AssistanceSettings\022\017\n\007caden" +
                    "ce\030\001 \001(\001\022\032\n\022timeSettingsEnable\030\002 \001(\010\"\236\001\n" +
                    "\022ResistanceSettings\022\017\n\007damping\030\001 \001(\001\022\017\n\007" +
                    "inertia\030\002 \001(\001\022\016\n\006torque\030\003 \001(\001\0227\n\032positio" +
                    "nOscillatorSettings\030\004 \001(\0132\023.OscillatorSe" +
                    "ttings\022\035\n\025PostionSettingsEnable\030\005 \001(\010\" \n" +
                    "\020RoadfeelSettings\022\014\n\004gain\030\001 \001(\001\"\365\002\n\007Comm" +
                    "and\022\037\n\006action\030\001 \001(\0162\017.Command.Action\022/\n\022" +
                    "assistanceSettings\030\002 \001(\0132\023.AssistanceSet" +
                    "tings\022/\n\022resistanceSettings\030\003 \001(\0132\023.Resi" +
                    "stanceSettings\022+\n\020roadfeelSettings\030\004 \001(\013" +
                    "2\021.RoadfeelSettings\0223\n\026timeOscillatorSet" +
                    "tings\030\005 \001(\0132\023.OscillatorSettings\"\204\001\n\006Act" +
                    "ion\022\r\n\tHeartbeat\020\000\022\010\n\004Idle\020\001\022\016\n\nGetSigna" +
                    "ls\020\002\022\024\n\020StartCalibration\020\003\022\023\n\017SetAssiste" +
                    "dMode\020\004\022\025\n\021SetResistanceMode\020\005\022\017\n\013SetRoa" +
                    "dfeel\020\006\">\n\021UnsignedIntSignal\022\013\n\003key\030\001 \001(" +
                    "\t\022\r\n\005units\030\002 \001(\t\022\r\n\005value\030\003 \001(\r\"6\n\tIntSi" +
                    "gnal\022\013\n\003key\030\001 \001(\t\022\r\n\005units\030\002 \001(\t\022\r\n\005valu" +
                    "e\030\003 \001(\005\"9\n\014DoubleSignal\022\013\n\003key\030\001 \001(\t\022\r\n\005" +
                    "units\030\002 \001(\t\022\r\n\005value\030\003 \001(\001\"\277\001\n\005Reply\022.\n\022" +
                    "unsignedIntSignals\030\001 \003(\0132\022.UnsignedIntSi" +
                    "gnal\022\036\n\nintSignals\030\002 \003(\0132\n.IntSignal\022$\n\r" +
                    "doubleSignals\030\003 \003(\0132\r.DoubleSignal\022\020\n\010po" +
                    "sition\030\004 \001(\001\022\017\n\007cadence\030\005 \001(\001\022\016\n\006torque\030" +
                    "\006 \001(\001\022\r\n\005power\030\007 \001(\001\"\031\n\tLED_Blink\022\014\n\004Fre" +
                    "q\030\001 \001(\rB\034\n\032de.kai_morich.usb_terminalb\006p" +
                    "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
            .internalBuildGeneratedFileFrom(descriptorData,
                    new com.google.protobuf.Descriptors.FileDescriptor[] {
                    });
    internal_static_OscillatorSettings_descriptor =
            getDescriptor().getMessageTypes().get(0);
    internal_static_OscillatorSettings_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_OscillatorSettings_descriptor,
            new java.lang.String[] { "Gain", "Period", "Phase", });
    internal_static_AssistanceSettings_descriptor =
            getDescriptor().getMessageTypes().get(1);
    internal_static_AssistanceSettings_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_AssistanceSettings_descriptor,
            new java.lang.String[] { "Cadence", "TimeSettingsEnable", });
    internal_static_ResistanceSettings_descriptor =
            getDescriptor().getMessageTypes().get(2);
    internal_static_ResistanceSettings_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_ResistanceSettings_descriptor,
            new java.lang.String[] { "Damping", "Inertia", "Torque", "PositionOscillatorSettings", "PostionSettingsEnable", });
    internal_static_RoadfeelSettings_descriptor =
            getDescriptor().getMessageTypes().get(3);
    internal_static_RoadfeelSettings_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_RoadfeelSettings_descriptor,
            new java.lang.String[] { "Gain", });
    internal_static_Command_descriptor =
            getDescriptor().getMessageTypes().get(4);
    internal_static_Command_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_Command_descriptor,
            new java.lang.String[] { "Action", "AssistanceSettings", "ResistanceSettings", "RoadfeelSettings", "TimeOscillatorSettings", });
    internal_static_UnsignedIntSignal_descriptor =
            getDescriptor().getMessageTypes().get(5);
    internal_static_UnsignedIntSignal_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_UnsignedIntSignal_descriptor,
            new java.lang.String[] { "Key", "Units", "Value", });
    internal_static_IntSignal_descriptor =
            getDescriptor().getMessageTypes().get(6);
    internal_static_IntSignal_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_IntSignal_descriptor,
            new java.lang.String[] { "Key", "Units", "Value", });
    internal_static_DoubleSignal_descriptor =
            getDescriptor().getMessageTypes().get(7);
    internal_static_DoubleSignal_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_DoubleSignal_descriptor,
            new java.lang.String[] { "Key", "Units", "Value", });
    internal_static_Reply_descriptor =
            getDescriptor().getMessageTypes().get(8);
    internal_static_Reply_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_Reply_descriptor,
            new java.lang.String[] { "UnsignedIntSignals", "IntSignals", "DoubleSignals", "Position", "Cadence", "Torque", "Power", });
    internal_static_LED_Blink_descriptor =
            getDescriptor().getMessageTypes().get(9);
    internal_static_LED_Blink_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_LED_Blink_descriptor,
            new java.lang.String[] { "Freq", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
