from flask import *
import Key


app = Flask(__name__)
messages = []


@app.route('/')
def route():
    return 'Hello!'


@app.route('/irc/get', methods=['GET'])
def get():
    requestKey = request.args.get('key', '')
    if Key.key != '':
        if requestKey == '':
            return 'No permission'
        if Key.key != requestKey:
            return 'No permission'
    else:
        return jsonify(messages)


@app.route('/irc/send', methods=['PUT', 'GET'])
def put():
    requestKey = request.args.get('key')
    message = request.args.get('message')
    username = request.args.get('username')
    if Key.key != '':
        if requestKey == '':
            return 'No permission'
        if Key.key != requestKey:
            return 'No permission'
    else:
        if len(message) > 40:
            message = []
            message.clear()
        if message == '' or username == '':
            return 'Invalid message!'
        messages.append(Message(message, username))


if __name__ == '__main__':
    app.run()


class Message:
    content = ''
    username = ''

    def __init__(self, content, username):
        self.content = content
        self.username = username
