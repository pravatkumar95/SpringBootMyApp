package websocketchatapplication.xmltojava.com.pack;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "methodResponse")
public class MethodResponse {
    private Params params;
@XmlElement
    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }
}

class Params {
    private Param param;
    @XmlElement
    public Param getParam() {
        return param;
    }

    public void setParam(Param param) {
        this.param = param;
    }
}

class Param {
    private Value value;
    @XmlElement
    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}

class Value {
    private Struct struct;
    @XmlElement
    public Struct getStruct() {
        return struct;
    }

    public void setStruct(Struct struct) {
        this.struct = struct;
    }
}

class Struct {
    private Member[] member;
    @XmlElement
    public Member[] getMember() {
        return member;
    }

    public void setMember(Member[] member) {
        this.member = member;
    }
}

class Member {
    private String name;
    private Value value;
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}

