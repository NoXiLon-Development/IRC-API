import json

from flask import Flask, request

import Key

app = Flask(__name__)

messages = []


@app.route('/')
def route():
    return 'Hello!'


@app.route('/irc/get', methods=['GET'])
def get():
    request_key = request.args.get('key', '')
    if Key.key != '':
        if request_key == '':
            return 'No permission'
        if Key.key != request_key:
            return 'No permission'
        if Key.key == request_key:
            return json.dumps([m.__dict__ for m in messages])
    else:
        return json.dumps([m.__dict__ for m in messages])


@app.route('/irc/send', methods=['PUT', 'GET'])
def put():
    request_key = request.args.get('key')
    message = request.args.get('message')
    username = request.args.get('username')
    if Key.key != '':
        if request_key == '':
            return 'No permission'
        if Key.key != request_key:
            return 'No permission'
        if Key.key == request_key:
            return get_message(message, username)
    else:
        return get_message(message, username)


def get_message(message, username):
    if len(message) > 40:
        message = []
        message.clear()
    if message == '' or username == '':
        return 'Invalid message!'
    messages.append(Message(message, username))
    return 'Message: ' + message + ',' + ' Username: ' + username


class Message:
    message = ''
    username = ''

    def __init__(self, message, username):
        self.message = message
        self.username = username


if __name__ == '__main__':
    app.run()
