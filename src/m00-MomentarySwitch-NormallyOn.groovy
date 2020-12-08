metadata {
	definition (name: "m00-MomentarySwitch-NormallyOn", namespace: "m00", author: "m00") {
		capability "Actuator"
		capability "Switch"
		capability "Momentary"
		capability "Sensor"
	}

	// simulator metadata
	simulator {
	}

	// UI tile definitions
	tiles {
		standardTile("switch", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "on", label: 'Push', action: "momentary.push", nextState: "off"
			state "off", label: 'Push', action: "momentary.push"
		}
		main "switch"
		details "switch"
	}
}

def parse(String description) {
}

def push() {
	sendEvent(name: "switch", value: "off", isStateChange: true, display: false)
	sendEvent(name: "switch", value: "on", isStateChange: true, display: false)
	sendEvent(name: "momentary", value: "pushed", isStateChange: true)
}

def on() {
	push()
}

def off() {
	push()
}